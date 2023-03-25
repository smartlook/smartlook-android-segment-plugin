#!/bin/bash

echo "⬆️  Creating Artifactory Snapshot..."
chars='abcdefghijklmnopqrstuvwxyz'
n=10
str=
for ((i = 0; i < n; ++i)); do
    str+=${chars:RANDOM%${#chars}:1}
done

./gradlew destination:publish -Pmaven.deploy.artifactory.snapshot=$str

echo "Done. Press any key to exit."
read  -n 1
done