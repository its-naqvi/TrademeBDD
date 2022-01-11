<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#Requirement">Requirement</a></li>
        <li><a href="#Built-With">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li>
      <a href="#Instructions">Instructions</a>
      <ul>
        <li><a href="#Ideal-combination-to-run-this-test-suite">Ideal combination to run this test suite</a></li>
        <li><a href="#Run-a-subset-of-Features-or-Scenarios">Run a subset of Features or Scenarios</a></li>
        <li><a href="#Run-on-other-Environment">Run on other Environment</a></li>
        <li><a href="#Run-on-different-browsers">Run on different browsers</a></li>
        <li><a href="#Reports-and-Logs">Reports and Logs</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

### Requirement:
Using the TradeMe Sandbox web site, write automation code which does the following:

1. As a Web UI test: Query any existing Used Car listing and confirm that the following details 
are shown for that car and that the values always match:
* Number plate
* Kilometres
* Body
* Seats
2. As an API test: Retrieve a list of charities and confirm that St John is included in the list.
3. As an API test: Perform the same query and checks as the Web UI test above but use the 
API not the UI.
The TradeMe Sandbox web site is available here: https://www.tmsandbox.co.nz/

Documentation for the TradeMe sandbox API is here: https://developer.trademe.co.nz/apireference/

#### PLEASE NOTE:
Sometimes there are no used cars in the sandbox environment, in which case please 
do test #1 and #3 using a book listing. Check for the title, description, seller, Buy Now price and
shipping options

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

Following tools and frameworks used to bootstrap your project. 

* [IntelliJ Commnuity Edition](https://www.jetbrains.com/idea/download/#section=windows/)
* [Cucumber](https://cucumber.io//)

## Project High Level Structure
Everything is under the *.\src\test package*

![image](https://user-images.githubusercontent.com/96668683/148872977-175ed615-8226-4278-9247-3607b98d6621.png)


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

Following tools are required to run this project
* [JDK 17](https://www.oracle.com/java/technologies/downloads/#jdk17-windows/)
* [Apache Maven 3.8.4](https://maven.apache.org/download.cgi/)


### Installation

Clone the repo:

Git:
```
$ https://github.com/its-naqvi/tradeMeBDD.git
```

Or download a ZIP of master [manually](https://github.com/its-naqvi/tradeMeBDD/archive/refs/heads/master.zip) and expand the contents someplace on your system

<p align="right">(<a href="#top">back to top</a>)</p>

## Instructions

1. Open a command-prompt app
2. Navigate to project directory
3. Run the below command
```
    mvn clean test
```
This runs all Cucumber features using TestNG runner.

*IMPORTANT NOTE*
At the time of writing, search feature wasn't working on trademe sandbox website. So in order to do used motor search please use the prod environment. 

### Ideal combination to run this test suite
Run API tests on tradeMe sandbox environment using Tag @API:
```
     mvn clean test -Denv=STAGE -D"cucumber.filter.tags=@API and @STAGE"
```

Run UI tests on tradeMe prod environment using Tag @UI as search feature is not working on Sandbox:
```
     mvn clean test -Denv=PROD -D"cucumber.filter.tags=@UI and @PROD"
```

### Run a subset of Features or Scenarios

To run only UI cases
```
     mvn clean test -D"cucumber.filter.tags=@UI"
```
To run only API cases
```
    mvn clean test -D"cucumber.filter.tags=@API"
```
To run only all regression cases
```
    mvn clean test -D"cucumber.filter.tags=@API"
```

<p align="right">(<a href="#top">back to top</a>)</p>

### Run on other Environment
By default cases execute on trademe sandbox enviornment i.e. STAGE.
```
    mvn test -Denv=STAGE
```
To run on PROD environment i.e. tradem.co.nz
```
    mvn test -Denv=PROD
```

### Run on different browsers
By default cases execute on chrome borwser but you can change the browser. For this test the only other available option is "firefox"
```
    mvn clean test -Denv=PROD -D"cucumber.filter.tags=@UI and @PROD" -Dbrowser=firefox
```

### Reports and Logs
* Cucumber reportes are generated under *".\target"*
* UI Error screenshots are stored *"\test-output\screenshots"* e.g. While clicking couldn't find the web element
* Logs are saved under *".\logs"*


<p align="right">(<a href="#top">back to top</a>)</p>