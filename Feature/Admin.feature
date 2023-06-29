Feature:Admin

@smoke 
Scenario: Succuessfully login with valid credensial
Given User launch chrome browser
When User open url"https://admin-demo.nopcommerce.com/login"
When User Enter Email as "admin@yourstore.com" and passward as "admin"
When Click on login
Then Page title should be "Dashboard / nopCommerce administration"
And Close browser


@regression
Scenario Outline: Login data driven
Given User launch chrome browser
When User open url"https://admin-demo.nopcommerce.com/login"
When User Enter Email as "<email>" and passward as "<passward>"
When Click on login
Then Page title should be "Dashboard / nopCommerce administration"
And Close browser

Examples:
 |email                    |passward   |
 |admin@yourstore.com      |admin      |
 |admin@yourstore.com      |admin123   |
|admin@yourstore.com      |admin123   |
|admin@yourstore.com      |admin123   |
|admin@yourstore.com      |admin123   |