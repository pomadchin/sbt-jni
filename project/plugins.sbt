// testing for sbt plugins
libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

addSbtPlugin("io.crashbox" % "sbt-gpg" % "0.2.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.3")
