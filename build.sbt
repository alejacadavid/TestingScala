name := "TestingScala"

version := "0.1"

scalaVersion := "2.12.6"


libraryDependencies  ++= Seq( "org.scalatest" %% "scalatest" % "3.0.5" % "test",
                          "org.scalactic" %% "scalactic" % "3.0.4",
                        "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
  "io.vavr" % "vavr" % "0.9.2",
  "junit" % "junit" % "4.12" % "test"
                        )