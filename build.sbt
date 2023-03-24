import scalariform.formatter.preferences._

lazy val root = project.in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    organization := "com.github.tototoshi",
    name := """csv2xls""",
    version := "0.1.1-SNAPSHOT",
    scalaVersion := "3.1.3",
    libraryDependencies ++= Seq(
      "com.github.scopt" %% "scopt" % "4.1.0",
      "org.apache.poi" % "poi" % "5.2.3",
      "com.github.tototoshi" %% "scala-csv" % "1.3.10",
      "org.scalatest" %% "scalatest" % "3.2.15" % "test"
    ),
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.github.tototoshi.csv2xls.buildinfo",
    publishMavenStyle := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (version.value.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    Test / publishArtifact := false,
    pomExtra := <url>http://github.com/tototoshi/csv2xls</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:tototoshi/csv2xls.git</url>
        <connection>scm:git:git@github.com:tototoshi/csv2xls.git</connection>
      </scm>
      <developers>
        <developer>
          <id>tototoshi</id>
          <name>Toshiyuki Takahashi</name>
          <url>https://github.com/tototoshi</url>
        </developer>
      </developers>
  )
