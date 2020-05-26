organization := "com.colisweb"
scalaVersion := "2.12.11"
libraryDependencies ++= Seq(
  "com.github.pathikrit" %% "dijon"        % "0.3.0",
  "org.scalatra.scalate" %% "scalate-core" % "1.9.6"
)

Global / onChangedBuildSource := ReloadOnSourceChanges
