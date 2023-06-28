Feature:Customer

Scenario Outline: Add New Customer
Given User launch chrome browser
When User open url"https://admin-demo.nopcommerce.com/login"
When User Enter Email as "<email>" and passward as "<passward>"
When Click on login
Then User can view Dashborad
When user click on customers menu
And user click on customers menu item
And user click on new add button
Then user can view add new customer page
When user enter customer info as "<newEmail>" and "<newpass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<admincomment>"
And click on save button
Then user can view confirmation msg "The new customer has beed added successfully."
And close browser

Examples:
|email|passward|newEmail|newpass|fname|lname|gemder|comName|admincomment|
|admin@yourstore.com|admin|sr123@gmail.com|1234|shital|rajule|female|ABC|test1|
|admin@yourstore.com|admin|sr1234@gmail.com|12345|chetan|more|male|XYZ|test2|
|admin@yourstore.com|admin|sr12345@gmail.com|12345|sanvi|pawar|female|PQR|test3|