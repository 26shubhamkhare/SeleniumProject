package stepdefinitions;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import base.base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.MainPage;
import org.openqa.selenium.TakesScreenshot;
public class Dropdown extends base {
	
	WebDriver driver;
	
		@Before("@Tableware")
	public void setup() {
		
		loadProjectDataProperties();
		driver = initializeBrowser(prop.getProperty("browser"));
		
	}
	@After("@Tableware")
	public void tearDown(Scenario scenario) throws IOException {
		
		if(scenario.isFailed())  {
			try {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				File screenshot_with_scenario_name = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				File destinationPath = new File("C:\\CapgSprint2\\TableWareOrdering\\screenshot\\"+screenshotName+".png");
				Files.copy(screenshot_with_scenario_name, destinationPath);
				
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				Reporter.addScenarioLog(screenshotName);
				scenario.embed(screenshot, "image/png");
			}  catch(Exception e) {
					System.out.println("Failed to take screenshot");
			}
		}
			
		driver.quit();
		
	}
	

	@Given("^I visit the website as a guest user$")
	public void i_visit_the_website_as_a_guest_user()  {
	   
		driver.get(prop.getProperty("url"));
	  
	}

	@When("^I select the Tableware from the Homepage$")
	public void i_select_the_Tableware_from_the_Homepage() {
		MainPage mainpage = new MainPage(driver);

    	mainpage.selectTableware();
	  
	}

	@And("^I click on Wooden Spoons option$")
	public void i_click_on_Wooden_Spoons_option()  {
   
		MainPage mainpage = new MainPage(driver);
		mainpage.ClickOnWoodenSpoons();           // To select Wooden Spoons under Table ware
	}

	@Then("^I should see all the varieties of Wooden Spoons$")
	public void i_should_see_all_the_varieties_of_Wooden_Spoons() {
	    
	}

	@And("^I should see the Cutlery as page heading$")
	public void i_should_see_the_Cutlery_as_page_heading()  {
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Cutlery']")).isDisplayed());
	   
	}

	
// Scenario 2 Sort function	

	@When("^I click on sort by popularity drop-down menu$")
	public void i_click_on_sort_by_popularity_drop_down_menu()  {
		MainPage mainpage = new MainPage(driver);
		mainpage.selectTableware();    // this will select the TableWare option
		
		mainpage.ClickOnWoodenSpoons();
		
		mainpage.selectSort();
	
	}

	@And("^I click on sort by average rating$")
	public void i_click_on_sort_by_average_rating() throws InterruptedException  {
		MainPage mainpage = new MainPage(driver);
        mainpage.selectSort();

        Select obj = new Select(driver.findElement(By.className("orderby")));
        obj.selectByVisibleText("Sort by average rating");
        Thread.sleep(2000);	
        }

	@Then("^I should see the product items according to their average rating$")
	public void i_should_see_the_product_items_according_to_their_average_rating()  {
	   
		
	}
	
	@And("^I click on sort by latest$")
	public void i_click_on_sort_by_latest() throws InterruptedException {
		MainPage mainpage = new MainPage(driver);
        mainpage.selectSort();
		     
		     Select obj = new Select(driver.findElement(By.className("orderby")));
		     
		        obj.selectByVisibleText("Sort by latest");
		        Thread.sleep(2000);	
	}
	
	@Then("^I should see the latest products$")
	public void i_should_see_the_latest_products()  {
	
	}
	
	@And("^I click on sort by price: low to high$")
	public void i_click_on_sort_by_price_low_to_high() throws InterruptedException {
		MainPage mainpage = new MainPage(driver);
        mainpage.selectSort();
		     
		     Select obj = new Select(driver.findElement(By.className("orderby")));
		        obj.selectByVisibleText("Sort by price: low to high");
		        Thread.sleep(2000);	
	}
	
	@Then("^I should see the product items with their prices started from low to high$")
	public void i_should_see_the_product_items_with_their_prices_started_from_low_to_high() {
	
	}
	
	@And("^I click on sort by price: high to low$")
	public void i_click_on_sort_by_price_high_to_low() throws Throwable {
		
		MainPage mainpage = new MainPage(driver);
        mainpage.selectSort();
        
		     Select obj = new Select(driver.findElement(By.className("orderby")));
		        obj.selectByVisibleText("Sort by price: high to low");
		        Thread.sleep(2000);	
	}
	
	@Then("^I should see the product items with their prices started from high to low$")
	public void i_should_see_the_product_items_with_their_prices_started_from_high_to_low()  {
	
	
	}

	// Scenario 3: Filter by price
	
	@When("^I drag the slider$")
	public void i_drag_the_slider()  {
			MainPage mainpage = new MainPage(driver);
			mainpage.selectTableware();    // this will select the TableWare option
			mainpage.ClickOnWoodenSpoons();
			WebElement slider = driver.findElement(By.xpath("//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[1]"));	
         Actions actions = new Actions(driver);
         actions.dragAndDropBy(slider, 100, 11).release().build().perform();
         slider.click(); 
         }

	@And("^I click on Filter$")
	public void i_click_on_Filter()  {
	  driver.findElement(By.xpath("//button[normalize-space()='Filter']")).click();
	}

	@Then("^I should see the product items between the price range$")
	public void i_should_see_the_product_items_between_the_price_range()  {
	   
	}
	
	// Scenario 4: User should be able to navigate to product Description page.
	
	@When("^I click on the product name$")
	public void i_click_on_the_product_name() {
		MainPage mainpage = new MainPage(driver);
		mainpage.selectTableware();    // this will select the TableWare option
	
		mainpage.ClickOnWoodenSpoons();
	 // main 
	  	driver.findElement(By.xpath("//a[contains(text(),'Wooden Masala Spoon (Set of 6) Compact for Salt, P')]")).click();
	
	}

	@Then("^I should see the product description$")
	public void i_should_see_the_product_description()  {
	   Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Product Description']")).isDisplayed());
	
	}
	
	//Scenario 5: Search Result Page
	
	
	@When("^I click on search bar$")
	public void i_click_on_search_bar() {
	   
		MainPage mainpage = new MainPage(driver);
		mainpage.ClickOnSearch("Wooden Spoon");
	
	}

	@And("^I search for Wooden Spoons$")
	public void i_search_for_Wooden_Spoons()  {
	   
	   
	}

	@Then("^I should see search result page for Wooden Spoons is loaded$")
	public void i_should_see_search_result_page_for_Wooden_Spoons_is_loaded() {
	   driver.findElement(By.xpath("//a[normalize-space()='View all results (34)']")).click();
	   
	}

	
	
	//Scenario 6: Add to cart functionality
	
	@When("^I select Wooden Spoons$")
	public void I_select_Wooden_Spoons()  {
		
		MainPage mainpage = new MainPage(driver);
		mainpage.selectTableware();    // this will select the TableWare option
		mainpage.ClickOnWoodenSpoons();
	
	}

	@And("^I click on the first product$")
	public void I_click_on_the_first_product()  {
	   
	  	driver.findElement(By.xpath("//a[contains(text(),'Wooden Masala Spoon (Set of 6) Compact for Salt, P')]")).click();

	}

	@Then("^I should see the product description page$")
	public void I_should_see_the_product_description_page() {
	  
		  Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Product Description']")).isDisplayed());

	}

	@And("^I click on plus button to increase the quantity$")
	public void I_click_on_plus_button_to_increase_the_quantity()  {
	   driver.findElement(By.xpath("//button[normalize-space()='+']")).click();
	   driver.findElement(By.cssSelector("button[class='plus qib-button']"));

	}

	@Then("^I click on ADD TO CART$")
	public void I_click_on_ADD_TO_CART()  {
		MainPage mainpage = new MainPage(driver);
		mainpage.AddToCart();
	
		//	driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click(); path of add to cart
		
	}

	@And("^I click on Checkout$")
	public void i_click_on_Checkout()  {
	    driver.findElement(By.cssSelector(".button.checkout.wc-forward")).click();
	}

	@Then("^I should see the Checkout page$")
	public void i_should_see_the_Checkout_page()  {
	   
		   Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ccblink ccbactive']")).isDisplayed());

		
	}

	//Scenario 7
	
	@When("^I select Wooden Spoons from tableware$")
	public void i_select_Wooden_Spoons_from_tableware()  {
		
		MainPage mainpage = new MainPage(driver);
		mainpage.selectTableware();    // this will select the TableWare option
		mainpage.ClickOnWoodenSpoons();
	
	}

	@And("^I click on the first product name$")
	public void i_click_on_the_first_product_name()  {
	   
	  	driver.findElement(By.xpath("//a[contains(text(),'Wooden Masala Spoon (Set of 6) Compact for Salt, P')]")).click();

	}

	@Then("^I should see the product information$")
	public void i_should_see_the_product_information() {
	  
		  Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Product Description']")).isDisplayed());

	}

	@And("^I click on plus button to increase the product quantity$")
	public void i_click_on_plus_button_to_increase_the_product_quantity()  {
	   driver.findElement(By.xpath("//button[normalize-space()='+']")).click();
	   driver.findElement(By.cssSelector("button[class='plus qib-button']"));

	}

	@Then("^I click on ADD TO CART option$")
	public void i_click_on_ADD_TO_CART_option()  {
		MainPage mainpage = new MainPage(driver);
		mainpage.AddToCart();
	
				
	}

	@And("^I click on View Cart$")
	public void i_click_on_View_Cart() {
		
	driver.findElement(By.linkText("View cart")).click();
	   
	}

	@Then("^I should see the product name with their quantity and price details in View cart page$")
	public void i_should_see_the_product_name_with_their_quantity_and_price_details_in_View_cart_page()  {
	   }
	
}
