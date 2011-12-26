#!/bin/sh

## Minecraft Land Generator - Readme Extractor
## Morlok8k - Updated 11/4/2011

## Just a simple script to help me update my readme file on github.
## MLG will display the readme with the "-readme" argument

cd ./bin/
chmod a+x ./MinecraftLandGenerator.jar

java -jar ./MinecraftLandGenerator.jar -conf

cd ..
java -jar ./bin/MinecraftLandGenerator.jar -readme README

rm ./MLG-BuildID

git add .
git commit -a
git push origin master
