Narrative:
In order to check a cart functionality

Scenario: Work with Ebay
Given User navigates to Ebay page
When User enter search criteria as <query>
When User click on the Search button
When User select first product
When User add the product to cart
Then Product count in cart should be <count>

Examples:
|query|count|
|Apple MacBook Pro|1|
|Apple MacBook Pro|1|
