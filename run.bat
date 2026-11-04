@echo off
REM Compile et execute tous les tests (JDK 11+) : run.bat
chcp 65001 >nul
if exist out rmdir /s /q out
mkdir out
dir /s /b src\main\java\*.java src\test\java\*.java > sources.txt
javac -encoding UTF-8 -d out @sources.txt || exit /b 1
del sources.txt
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -cp out inf4067.solid.test.AllTests
