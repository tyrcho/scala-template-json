organization := "com.colisweb"
scalaVersion := "2.12.11"
libraryDependencies ++= Seq(
  "com.lihaoyi"          %% "upickle"      % "0.7.1",
  "org.scalatra.scalate" %% "scalate-core" % "1.9.6"
)

Global / onChangedBuildSource := ReloadOnSourceChanges
