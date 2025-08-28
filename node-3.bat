@echo off
set PEKKO_PORT=2553
set HTTP_PORT=8082
sbt -Dsbt.supershell=false -Dsbt.server=false "runMain com.example.pekko.MultiNodeMain"
pause
