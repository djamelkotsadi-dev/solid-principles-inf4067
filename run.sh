#!/bin/sh
# Compile et exécute tous les tests (JDK 11+) : ./run.sh
set -e
rm -rf out && mkdir out
FILES=$(find src/main/java src/test/java -name '*.java')
if command -v javac >/dev/null 2>&1; then
  javac -encoding UTF-8 -d out $FILES
else
  java -m jdk.compiler/com.sun.tools.javac.Main -encoding UTF-8 -d out $FILES
fi
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -cp out inf4067.solid.test.AllTests
