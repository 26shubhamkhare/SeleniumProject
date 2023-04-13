package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainPage {
WebDriver driver;
	
	public MainPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Tableware']")
	WebElement TablewareDropMenu;
	
	@FindBy(xpath="//div[@class='shoptimizer-sorting']//select[@name='orderby']")
	WebElement SortOption;
	
	@FindBy(xpath="//input[@id='woocommerce-product-search-field-0']")
	WebElement Search;
	
	@FindBy(xpath="//span[normalize-space()='Wooden Spoons']")
	WebElement  WoodenSpoons;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	WebElement Cart;
	
	public void selectTableware() {
		
		TablewareDropMenu.click();
		
	}
	
	public void selectSort() {
		

			SortOption.click();
		
	}
	
	public void ClickOnSearch(String searchtext)  {
		
		Search.sendKeys(searchtext);
		

	}

	public void ClickOnWoodenSpoons() {
		
		WoodenSpoons.click();
		
	}
	
	
	public void AddToCart() {
		Cart.click();
	}

}
