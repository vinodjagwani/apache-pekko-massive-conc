@echo off
set PEKKO_PORT=2552
set HTTP_PORT=8081
sbt -Dsbt.supershell=false -Dsbt.server=false "runMain com.example.pekko.MultiNodeMain"
pause
