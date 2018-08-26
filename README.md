# Test framework example

##Tools


1. Java 1.8
1. Maven
1. Selenium WD
1. Cucumber
1. JUnit
1. PageObject Pattern

##Comments

The project contains following components:

`.features` files that describe test scenarios in a Gherkin format are located in `test/resourses`

Package `com.quandoo.steps` contains implementation of scenarios' steps.

Package `com.qundoo.config` contains a class with cucumber hooks

Package `com.quandoo.page` contains classes of pages under test    


## How to run
In order to run the tests please ensure you have Google Chrome web browser installed
Navigate to the project root and run from the terminal
```{bash}
mvn test
```
After tests finish please do either of the following to see the test report
* Open target/cucumber-report/index.html in a web browser
* Open target/cucumber-report.json in a text editor or similar

## Future work

* Add webdriver wait for elements that can be a bit slow.

* Static driver can be a poor place for concurrent test execution.

* Add asserj library that contains more useful assertion methods. 