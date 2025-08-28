ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

lazy val root = (project in file("."))
  .settings(
    name := "apache-pekko-massive-conc",
    idePackagePrefix := Some("com.example.pekko")
  )

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-actor-typed" % "1.1.2",
  "org.apache.pekko" %% "pekko-cluster-typed" % "1.1.2",
  "org.apache.pekko" %% "pekko-http" % "1.1.0",
  "org.apache.pekko" %% "pekko-cluster-sharding-typed" % "1.1.2",
  "ch.qos.logback" % "logback-classic" % "1.5.6",
   "org.slf4j" % "slf4j-api" % "2.0.13"
)