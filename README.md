Project "test.SearchTermInGoogle"

Tools for installation:

1. Mozilla Firefox version 62 installed (latest);
Go to https://www.mozilla.org/en-US/firefox/new/;
Download 'Firefox Installer.exe';
Install 'Mozilla Firefox'.

2. JDK 10.0.2;
Go to http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html;
Download 'jdk-10.0.2_windows-x64_bin.exe' or 32 bit;
Install 'jdk-10.0.2_windows-x64_bin.exe'.


3. Intellij IDEA 'Community' version;
Go to https://www.jetbrains.com/idea/download/#section=windows;
Download 'ideaIC-2018.2.4.exe';
Install 'IntelliJ IDEA'.

4. geckodriver;
Download 'geckodriver-v0.23.0-win64.zip';
Copy archive content;
Paste archive content in C:\Windows\System32;

5. Selenium Java » 3.14.0;
Selenium is a tool for automating web browser actions. How to install 'Selenium Java » 3.14.0':
Go to https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.14.0;
Copy Maven text;
Open pom.xml in Intellij IDEA;
In pom.xml before '</project>' write '<dependencies>';
Paste Maven text after '<dependencies>';
Write after Maven text '</dependencies>'.

6. Git
Go to https://git-scm.com/downloads;
Download 'Git-2.19.1-64-bit.exe';
Install Git.

7. TestNG
TestNG - a testing framework for the JVM. How to install 'TestNG':
Go to https://mvnrepository.com/artifact/org.testng/testng/6.14.3;
Copy Maven text;
Open pom.xml in Intellij IDEA;
In pom.xml before '</dependencies>' paste Maven text.



How to run the current test script:
Choose 'basicSearchPage.java'
Click on menu bar 'Run'.
Click in drop down menu 'Run 'basicSearchPage'


Project include 2 folder: "page" and "test".

Folder "page" include classes:
1. BasePage - include method waitUntilElementIsClickable for wait loaded any WebElements.

2. SearchPageBase include:
 - isDisplayedSearchField - Method for identification field on display.
 - isPageLoaded - Method for validation Page loaded.
 - setSearchTerm - Method, which transmits searchTerm, click Find searchTerm and returned new Page.

3. SearchPage1 include:
 - isDisplayedSearchField - Method for identification field on display.
 - clickPage1 - Method, which click second Page and returned new Page.
 - isPageLoaded - Method for validation Page loaded.
 - countSearchResultFromPage1 - Method for find blocks with searchTerm on Page1 and count find block with searchTerm.

4. SearchPage2 include:
 - isDisplayedSearchField - Method for identification field on display.
 - isPageLoaded - Method for validation Page loaded.
 - countSearchResultFromPage2 - Method for find blocks with searchTerm on Page2 and count find block with searchTerm.


Folder "test" include classes:
1. BaseTest include methods:
 - beforeMethod - Method for connect FirefoxDriver and navigate to links "https://www.google.com".
 - afterMethod - Method, which closed browser after work.

2. SearchTermInGoogle include method basicSearchPage, which do across between page and find searchTerm "Selenium". Also,
it compare expected and actual result.

