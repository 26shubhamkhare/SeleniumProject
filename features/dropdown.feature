Feature: TableWare Ordering functionality

Background: 
Given I visit the website as a guest user

@TWS1 @Tableware
Scenario: User is able to find Wooden Spoons under Tableware

When I select the Tableware from the Homepage
And I click on Wooden Spoons option
Then I should see all the varieties of Wooden Spoons 
And I should see the Cutlery as page heading


@TWS2  @Tableware
Scenario: User is able to sort the items by using different options

When I click on sort by popularity drop-down menu
And I click on sort by average rating
Then I should see the product items according to their average rating
And I click on sort by latest
Then I should see the latest products
And I click on sort by price: low to high
Then I should see the product items with their prices started from low to high
And I click on sort by price: high to low
Then I should see the product items with their prices started from high to low

@TWS3	 @Tableware
Scenario: User is able to use Slider to filter the product items by Price

When I drag the slider 
And I click on Filter
Then I should see the product items between the price range

@TWS4	 @Tableware
Scenario:  User is able to open the product and navigate to the product description page.

When I click on the product name 
Then I should see the product description


@TWS5	 @Tableware
Scenario: User is able to search products using search bar

When I click on search bar
And I search for Wooden Spoons
Then I should see search result page for Wooden Spoons is loaded


@TWS6  @Tableware
Scenario: User can select the product quantity and proceed to the checkout page for placing an order.
 
When I select Wooden Spoons
And I click on the first product
Then I should see the product description page
And I click on plus button to increase the quantity
Then I click on ADD TO CART 
And I click on Checkout
Then I should see the Checkout page


@TWS7  @Tableware
Scenario: User is able to see the products which are added into the Cart 

When I select Wooden Spoons from tableware
And I click on the first product name
Then I should see the product information
And I click on plus button to increase the product quantity
Then I click on ADD TO CART option
And I click on View Cart
Then I should see the product name with their quantity and price details in View cart page









