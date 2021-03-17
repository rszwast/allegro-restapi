# Allegro REST API tests

Integration test project based on Allegro REST API

## Technologies and tools used

* java, ver 1.8 - basic programming language
* maven, ver 3.6.1 - tool for managing and building project
* rest-assured, ver 4.3.0 - java library that allows to write REST API tests 
* testNG, ver 7.1.0 - framework to run and manage tests
* assertJ, ver 3.16.1- to used advanced assertions
* gson, ver 2.8.6 - object serialization library
* owner, ver 1.0.12 - library that allows to easily read *.properties files

## About
Test cases in project cover three endpoints:
 * Get IDs of Allegro categories
 * Get a category by ID
 * Get parameters supported by a category

from the [documentation](https://developer.allegro.pl/documentation/#tag/Categories-and-parameters)

## To run test

After download the project use command below in your terminal / command line

```mvn clean test```

![Alt text](screenshots/ScreenShot_002.png?raw=true)

or right-click somewhere in the test_suite.xml like in the screen below:

![Alt text](screenshots/ScreenShot_001.png?raw=true)
