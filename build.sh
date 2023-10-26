#!/bin/bash

export APP=$(cat settings.gradle | grep -m 1 '^rootProject.name' | awk -F '"' '$0=$2')
export VERSION=$(cat build.gradle | grep -m 1 '^version' | awk -F '"' '$0=$2')

cd front
npm ci
npm run build
rm -rf ../src/main/resources/web/*
cp build/* ../src/main/resources/web/
cd ..

./gradlew clean build

helm lint chart/
