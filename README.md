# selenium-web-automation-gradle

## Technology:
- Tool: selenium
- IDE: IntelIJ
- Build tool: Gradle
- Language: Java
- Framework: TestNG


## Requirement:
1. Navigate to an ecommerce site
2. Register a customer account with unique email
3. Login to customer account
4. Search for an item by typing 'dress' on search box
5. Add to cart
6. Checkout item
7. Assert with purchase confirmation message

## Prerequisite:
1. Need to install jdk 1.8
2. Need good internet connectivity

## Run the automation script:
1. Open cmd to the project folder
2. Type this command:

```sh
gradle clean test
```
3. Selenium will open the browser and start automation.
4. To view report, type this command:
```sh
allure generate allure-results --clean -o allure-report
allure serve allure-results
```
## Report View

![2021-09-20_23-58-01](https://user-images.githubusercontent.com/48891202/134051081-3f7040bb-7853-46ff-bbea-10e082b15869.png)
![2021-09-20_23-58-22](https://user-images.githubusercontent.com/48891202/134051088-c1f3ec56-3472-482f-8557-ae23698006a5.png)

You will find the automation <a href="https://youtu.be/VzlgCcbHZWU" target="_blank">video</a> here.
