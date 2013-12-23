name := "Scalaton"

version := "1.0"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
    "com.sun.jersey" % "jersey-server" % "1.2",
    "com.sun.jersey" % "jersey-json" % "1.2",
    "org.eclipse.jetty" % "jetty-server" % "8.0.0.M0",
    "org.eclipse.jetty" % "jetty-servlet" % "8.0.0.M0",
    "commons-httpclient" % "commons-httpclient" % "3.0-rc4",
    "org.scalatest" % "scalatest_2.10" % "2.0.M6-SNAP28",
    "com.propensive" % "rapture-io" % "0.7.2"
)