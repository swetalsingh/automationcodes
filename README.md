# automationcodes

This Repository contains selenium automation framework built using Java and Maven. It follows the Page Object Model (POM) design pattern for the UI automation and also includes API testing using Rest Assured.

## Framework
- Test runner: TestNG
- Browser automation: Selenium WebDriver
- Design: Page Object Model (POM)
- Build Tool: Maven
- API Testing: Rest Assured
- Language: Java

## Getting started
### Setup 
1. Clone the repo:
   - git clone https://github.com/swetalsingh/automationcodes.git
2. Enter the project and create a feature branch:
   - cd automationcodes
   - git checkout -b feature/<short-description>
3. Install dependencies / build:
   - If Maven: mvn clean test-compile
4. Run tests:
   - If using TestNG suite XML: mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
   - Or run a specific TestNG suite/class via your IDE or build tool
5. View screenshots/reports:
   - TestNG HTML: target/surefire-reports or test-output (TestNG default)
   - Screenshots can be viewed from the screenshots folder inside the repo
6. Push changes and open PR:
   - git add .
   - git commit -m "feat: <short description>"
   - git push origin feature/<short-description>

## Project layout 
- src/main/java/org.example/amazonFactory/SeleniumFactory - Contains properties and browser initialization methods.
- src/main/java/org.example/Pages - Contains 2 page classes - Home page, Electronics (Sub category) Page implementing page actions and containing webelements of respective pages.
- src/test/java/org.example/APITest - Contains methods for different curd operations (GET, PUT, POST, DELETE).  
- src/test/java/org.example/BaseTest - Contains Reusable methods across the framework for UI and API tests in their respective classes.
- src/test/java/org.example/UITests - Contains test methods for the UI.
- Properties- This file contains configuration variables like browser name and URL.
- Screenshots- This folder stores the captured screenshots.

## Chosen websites/APIs
  - UI:  https://www.amazon.in/
  - API: https://petstore.swagger.io/v2


