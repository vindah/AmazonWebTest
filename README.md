# AmazonWebTest
This repo consists of cypress test code for some test cases created for this page : https://www.amazon.in/
It scrolls through the menu options, selects a product, filters and clicks on the second highest, then logs its about to the console.

## Installation/Running the code
1. Have Java installed on your machine.

2. Clone the repo by first navigating to the the folder on your terminal that you want to create the project then run:
`git clone https://github.com/vindah/AmazonWebTest.git`

or clone directly on preferred IDE

3. Open project on preferred IDE(IntelliJ, Eclipse,VSCode, etc).

4. If dependencies are not updated, navigate to "pom.xml" file and sync the dependencies

5. Configure JUnit runner on your IDE and pass class name as "runner.testRunner"

## Installing Other project needs
1. Install docker for your machine
Navigate to 'https://hub.docker.com/r/selenium/hub', copy Selenium hub command and run in terminal.

2. Install selenium server standalone.jar file. For this, version 4.1.3 was used.

3. In machine terminal, run:
`java -jar selenium-server-4.1.3-alpha-7.jar standalone`

4. For docker images, follow syntx:
`docker pull selenium/node-<browser(e.g "chrome")>` - This would help with headless running
and
`docker pull selenium/node-<browser(e.g "chrome")>-debug`

5. To bring up docker containers, in IDE terminal, navigate to folder where docker is and run:
`docker-compose up -d`

6. To remove/tear down containers, run:
`docker-compose down`

**To run Test in headless:**
1. Navigate to the driver factory file:
"src/main/java/utilities/driverFactory"
Scroll and find **options.addArguments("--headless");** and then remove comment.
Ensure to comment out/disable **options.addArguments("start-maximized");**

2. To run via build run button, navigate to testRunner file in path:
"src/test/java/testRunner" and click on run or click on the run button beside Junit build configuration

3. To run via command prompt:
Navigate to root directory and run:
`mvn test`

**To run Test in header**
1. Navigate to the driver factory file:
"src/main/java/utilities/driverFactory"
2. Ensure that **options.addArguments("start-maximized");** is active
3. Click on the JUnit build runner to run.


**Run with Visual testing** 

For this project, Applitools eyes was setup

You can un-comment and use applitools eyes for visual tests(this is currently commented out in **step file**). To run this for yourself you need to create 
...an applitools account to enable you view the results, get an applitools api key, add the applitools dependencies 
... and substitute the key in the "configtion.properties" file under path **"src/test/resources/profiles/testProd/configuration.properties"** to test.




## Note:
The test was setup to run on local device. You can always update the relevant paths in **configuration.properties** file if needed.
