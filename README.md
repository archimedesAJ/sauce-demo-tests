## Introduction
This project demonstrates automated testing of an ecommerce website using Java, Selenium WebDriver, TestNG, ExtentReport and Apache POI for data-driven testing.

## Overview
This automation project aims to verify the functionality of an ecommerce website through automated tests. It utilizes Selenium WebDriver for interacting with web elements, TestNG for test execution and reporting, and Apache POI for data-driven testing by reading test data from Excel files.

## SetUp Instruction
1. `Clone the repository`: https://github.com/archimedesAJ/sauce-demo-tests or `download zip file`
2. `Import Project into IDE`: Import the project into your preferred Java IDE (Eclipse, IntelliJ IDEA, etc.).
3. `Install Dependencies`: Ensure that you have Java, Maven, and TestNG installed on your system. You can manage dependencies using Maven's pom.xml file.
4. `Run Tests`: Execute the test suite using TestNG. You can run tests from your IDE or via Maven command line.

## How to run the tests
1. `Running a single Test Class`: e.g mvn test -Dtest="LoginTest"
2. `Running a profile test`: e.g mvn test -Psmoke
3. `Running all tests`: e.g mvn clean test
4. `Running testng file`: e.g mvn test -DsuiteXmlFile=testng_all.xml

## Usage
- Add new test cases as needed under the tests package.
- Utilize Page Object Model (POM) for maintaining web element locators and actions in separate classes.
- Enhance test data management by extending Apache POI functionalities as required.
- Execute tests and review reports to verify website functionalities and identify issues.

## Contributor
Feel free to contact me on [aabbeyjr25@gmail.com | +233531952539 )

## Ecommerce site
The ecommerce site can be accessed via this link https://www.saucedemo.com/

