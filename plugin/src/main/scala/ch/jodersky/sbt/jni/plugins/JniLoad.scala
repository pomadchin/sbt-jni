package ch.jodersky.sbt.jni
package plugins

import sbt._
import sbt.Keys._

object JniLoad extends AutoPlugin {

  override def requires = empty
  override def trigger = allRequirements

  lazy val settings: Seq[Setting[_]] = Seq(
    // Macro Paradise plugin and dependencies are needed to expand annotation macros.
    // Once expanded however, downstream projects don't need these dependencies anymore
    // (hence the "Provided" configuration).
    libraryDependencies ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, n)) if n >= 13 => Seq()
        case Some((2, n)) =>
          Seq(compilerPlugin(("org.scalamacros" % "paradise" % ProjectVersion.MacrosParadise).cross(CrossVersion.full)))
        case _ => Seq()
      }
    },
    Compile / scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, n)) if n >= 13 => Seq("-Ymacro-annotations")
        case _                       => Seq()
      }
    },
    resolvers += Resolver.jcenterRepo,
    libraryDependencies ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, n)) =>
          Seq("org.scala-lang" % "scala-reflect" % scalaVersion.value % Provided)
        case _ => Seq()
      }
    },
    libraryDependencies += "ch.jodersky" %% "sbt-jni-macros" % ProjectVersion.Macros % Provided
  )

  override def projectSettings = settings

}
