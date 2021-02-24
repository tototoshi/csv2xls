import scalariform.formatter.preferences._

enablePlugins(JavaAppPackaging)

name := """csv2xls"""

version := "0.1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.github.scopt" %% "scopt" % "4.0.0",
  "org.apache.poi" % "poi" % "3.17",
  "com.github.tototoshi" %% "scala-csv" % "1.3.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)
