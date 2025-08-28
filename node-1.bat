@echo off
set PEKKO_PORT=2551
set HTTP_PORT=8080
sbt -Dsbt.supershell=false -Dsbt.server=false "runMain com.example.pekko.MultiNodeMain"
pause
