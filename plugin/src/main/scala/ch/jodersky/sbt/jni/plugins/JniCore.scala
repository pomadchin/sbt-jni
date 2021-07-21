package ch.jodersky.sbt.jni
package plugins

import sbt._
import sbt.Keys._

object JniCore extends AutoPlugin {
  lazy val settings: Seq[Setting[_]] = Seq(
    libraryDependencies += "ch.jodersky" %% "sbt-jni-core" % ProjectVersion.Macros
  )
  override def projectSettings = settings
}
