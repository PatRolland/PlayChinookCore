name := """PlayChinookCore"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.13",
  "postgresql" % "postgresql" % "9.1-901.jdbc4"
)
