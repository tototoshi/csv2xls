import scalariform.formatter.preferences._

enablePlugins(JavaAppPackaging)

name := """csv2xls"""

version := "0.1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.github.scopt" %% "scopt" % "3.7.1",
  "org.apache.poi" % "poi" % "3.12",
  "com.github.tototoshi" %% "scala-csv" % "1.2.2",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)
