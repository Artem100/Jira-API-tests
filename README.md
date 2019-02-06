# API tests for Jira

## General info
The main goal of project - show the work code of API(v.2) tests for Jira.

## Technologies
* JDK 1.8;
* Maven;
* Allure;

## Setup
To run this project:
1. In property file (Jira-API-tests/src/main/resources/credentials.properties) add your values of username and password. (If you have account in http://jira.hillel.it:8080)
2. To run the test, go to project directory and run the commands:
```
$ mvn clean test
```
3. To look the results of tests, run the command:
```
$ mvn site
```
3.1 Go to directory with reported (/target/site/allure-maven.html) and open it browser.


[![CircleCI](https://circleci.com/gh/Artem100/LR20.svg?style=svg)](https://circleci.com/gh/Artem100/LR20)
