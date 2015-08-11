name := """tracker"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.28",
   javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final",
  "org.apache.velocity" % "velocity" % "1.7",
  "org.apache.activemq" % "activemq-all" % "5.6.0"  
 )

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
