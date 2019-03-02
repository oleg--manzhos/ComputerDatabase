# Computer Database project

To start all tests in Chrome (starts by default), the following command should be executed:
```
mvn clean test
```

_NOTE:_ Automation project uses Boni's Garcia Driver Manager that automatically downloads driver version that fits your browser. Please ensure that your firewall/proxy is configured properly to let the driver be downloaded.

##Test Execution
There are several ways to run tests
### IDE way
You can run tests from your IDE. 
### Run tests in batch and individually
To run tests in firefox or IE the following parameters should to be passed as command line argument's value:
```
mvn clean test -Dselenide.browser=firefox
```
or
```
mvn clean test -Dselenide.browser=ie
```
Project contains surefire plugin that allows to run tests separately:
```
mvn clean test -Dtest=DeleteComputerTest
```
 The complete list of test methods:
 * AddComputerHappyPathTest
 * AddComputerUnhappyPathTest
 * EditComputerHappyPathTest
 * EditComputerUnhappyPathTest
 * DeleteComputerTest
 
 Any of these classes could be run separately using -D*test* parameter.
 
 ###Runnig with report
 Report on results of testing could be generated based on Maven Surefire plugin.
 To run report generation, it is necessary to start tests using the following command:
 ```
 mvn clean site
```
Report for individual test can also be generated:
```
mvn clean site -Dtest=AddComputerHappyPathTest
```
After execution will be finished, the report will be located here:
[target/surefire-reports/index.html](target/surefire-reports/index.html)