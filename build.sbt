import sbt.Keys._

lazy val commonSettings = Seq(
  scalaVersion := "2.12.7"
)

lazy val `typemailer-core` = project.settings(
  commonSettings
)

lazy val `typemailer-cats-effect` = project.settings(
  commonSettings,
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "1.0.0"
  )
).dependsOn(`typemailer-core`)

lazy val `typemailer-adapter-debug` = project.settings(
  commonSettings,
  libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-api" % "1.7.25"
  )
).dependsOn(`typemailer-core`)

lazy val `typemailer-integration-test` = project.settings(
  commonSettings,
  libraryDependencies ++= Seq(
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
    "org.scalactic" %% "scalactic" % "3.0.5",
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )
).dependsOn(`typemailer-adapter-debug`, `typemailer-cats-effect`)