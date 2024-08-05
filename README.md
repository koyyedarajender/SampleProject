To set up the project in local to develop scripts:

1. Download Intellij/eclipse
2. Download maven 3.9.3
3. Download JDK 17 to any latest
4. Import project to Intellij/eclipse
5. Download the browser drivers required in your system (e.g. see [Chrome Drivers Download Page](https://chromedriver.chromium.org/home))
6. Run `maven clean test -Dcucumber.filter.tags=@smoke`

To Develop and push code

1. Create your own branch using main branch "master"
2. Develop scripts
3. Commit and push your code
4. Then raise pull request against branch "master"
5. Once pull request approved by at least one qa merge code to master

Execute and Reports

6. Run from terminal the command "mvn clean install" it will run integrumTest.java
7. After execution, there will be "reports" folder create and open "overview-features.html" then we get good UI report

NOTES:

9. Please give feature file name like
   moduleName_TestcaseNumber.feature
   Eg:SmartFormBuilder_1760147.feature
10. Please push/merge code into master branch once Testcase ran/passed on local & jenkins with your own branch
