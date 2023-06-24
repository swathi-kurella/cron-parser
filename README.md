# Context
Cron Parser is an app to evaluate a given cron expression with and a command to execute
# Steps to run

## Step 1: 
Buid the Project to generate executable Jar file
./gradlew build

## Step 2:
Copy Jar to required destination
cp ./build/libs/cron-parser-1.0-SNAPSHOT.jar .

## Step 3:
Create alias for the Jar execution command. In this case, 'cron-parser' is the command created.
alias cron-parser="java -jar cron-parser-1.0-SNAPSHOT.jar"

## Usage:

cron-parser "*/15 0 1,15 * 1-5 /usr/bin/find"

## Run tests
./gradlew test