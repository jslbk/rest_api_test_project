# [Reqres.in](https://reqres.in) API test automation project demo

<img alt="Reqres.in" src="media/Reqres.png" width="100%">

----
## 📂 Content

- <a href="#tools"> Tools</a>
- <a href="#cases"> Test cases</a>
- <a href="#autotests"> Running Automated Tests</a>
- <a href="#jenkins"> Jenkins Build</a>
- <a href="#allureReport"> Example of Allure Report</a>
- <a href="#allure"> Integration with Allure TestOps</a>
- <a href="#jira"> Integration with Jira</a>
- <a href="#telegram"> Telegram notifications</a>

____
<a id="tools"></a>
## 🛠️ Tools

<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/Java.svg"></a>
<a href="https://rest-assured.io/"><img width="6%" title="Java" src="media/RestAssured.png"></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="media/Jira.svg"></a>
<a href="https://allurereport.org/"><img width="6%" title="Allure Report" src="media/Allure.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/Junit5.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/Telegram.svg"></a>
</p>

____
The project utilizes <code>[Java](https://www.java.com/)</code> along with <code>[REST Assured](https://rest-assured.io/)</code> for API testing. 
Integration with tools like </code>[Jira](https://www.atlassian.com/ru/software/jira/)</code> for issue tracking, <code>[Allure](https://allurereport.org/)</code> for test reporting, and <code>[Jenkins](https://www.jenkins.io/)</code> for continuous integration. 
<code>[Gradle](https://gradle.org/)</code> is used for project automation along with <code>[JUnit5](https://junit.org/junit5/)</code> for test execution. Integration with <code>[Allure TestOps](https://qameta.io/)</code>, provides connection for test management and analysis.

After the completion of a build, the <code>[Telegram](https://web.telegram.org/)</code> bot automatically processes and dispatches a message containing the test run report to a pre-configured chat.

> Allure report is additionally customized by the provided AllureListener.
> This customization allows for the inclusion of custom templates for requests and responses, enhancing the clarity and presentation of the test report.

____
<a id="cases"></a>
## 🗒️ Test cases

#### Login Feature
- Check user not found login response
- Check successful login response

#### Registration Feature
- Verify successful registration
- Verify bad email registration
- Verify empty email registration
- Verify empty password registration

#### User Data Verification Feature
- Verify not found response for specific user
- Verify response data for specific user

----
## ▶️ Running the API tests

To run **all** the tests:
```zsh
gradle clean test
```

To run only **login** tests:
```zsh
gradle clean login_test
```

To run only **registration** tests:
```zsh
gradle clean registration_test
```

To run only **signle user data** tests:
```zsh
gradle clean user_test
```

____
<a id="jenkins"></a>
## <img width="4%" style="vertical-align:bottom" title="Jenkins" src="media/Jenkins.svg"> </a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/api_test_automation/lastBuild/"> Build </a>

To start the build, go to the "Build with parameters" section, select the necessary parameters, and click "Build".

> Registration on the [Jenkins](https://jenkins.autotests.cloud/) resource is required for access to Jenkins.

### Jenkins Build Parameters:
- TASK (set of tests to run)
- BASE (tested site base url)

<p align="center">
<img title="Jenkins Build" src="media/Jenkins.png">
</p>

> After the build is completed, icons for "Allure Report" and "Allure TestOps" will appear next to the build number in the "Build History" section. Clicking on these icons opens pages with the generated HTML report and test documentation, respectively.

____
<a id="allureReport"></a>
## <img width="4%" style="vertical-align:bottom" title="Allure Report" src="media/Allure.svg"> </a> Example of <a target="_blank" href="https://jenkins.autotests.cloud/job/api_test_automation/allure/"> Allure Report </a>

<p align="center">
<img title="Allure Overview" src="media/Allure.png">
</p>

<p align="center">
<img title="Allure Graphs" src="media/AllureGraphs.png">
</p>

____
<a id="allure"></a>
## <img width="4%" style="vertical-align:bottom" title="Allure TestOps" src="media/AllureTestOps.svg"> </a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/4126/dashboards"> Allure TestOps </a>

On the *Dashboard* in **Allure TestOps**, you can see the statistics of the number of tests: how many of them are added and executed manually, how many are automated. New tests and test run results are sent through the integration with each build.

<p align="center">
<img title="Allure TestOps Cases" src="media/AllureTestOpsCases.png">
</p>

<p align="center">
<img title="Allure TestOps Dashboard" src="media/AllureTestOpsDash.png">
</p>

<p align="center">
<img title="Allure TestOps Graphs" src="media/AllureTestOpsGraphs.png">
</p>

____
<a id="jira"></a>
## <img width="4%" style="vertical-align:bottom" title="Jira" src="media/Jira.svg"> </a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1161"> Jira </a>

Integration with **Allure TestOps** and **Jira** is implemented. In the Jira task, you can see which test cases were written as part of the task and their execution results.

<p align="center">
<img title="Jira Task" src="media/JiraTask.png">
</p>

____
<a id="telegram"></a>
## <img width="4%" style="vertical-align:bottom" title="Telegram" src="media/Telegram.svg"> Telegram notifications via bot

After the build is complete, a **Telegram** bot automatically processes and sends a message with the test run report to a specifically configured chat.

<p align="left">
<img width="30%" title="Telegram Notifications" src="media/TelegramBot.jpeg">
</p>
