#!/bin/bash

export APP=$(cat settings.gradle | grep -m 1 '^rootProject.name' | awk -F '"' '$0=$2')
export VERSION=$(cat build.gradle | grep -m 1 '^version' | awk -F '"' '$0=$2')

cd front
npm install --package-lock
npm ci
npm run build
rm -rf ../src/main/resources/web/*
cp -r build/* ../src/main/resources/web/
cd ..

./gradlew clean build

helm lint chart/

docker build . -t repo.gcg.name/gcg-docker/$APP:$VERSION
docker push repo.gcg.name/gcg-docker/$APP:$VERSION

helm package chart/ --app-version $VERSION --version $VERSION
sleep 20
helm repo update
helm upgrade $APP gcg/$APP --install --wait --version $VERSION --namespace apps --timeout 5m
