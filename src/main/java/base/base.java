package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else if(browser.equalsIgnoreCase("opera")) {
			
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	
	public void loadProjectDataProperties() {
		
		prop = new Properties();
		
		String projectPath = System.getProperty("user.dir");
		
		File file = new File(projectPath+"\\src\\main\\java\\resources\\ProjectData.properties");
		
		try {
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		}catch(Throwable t) {
			
			System.out.println(t.getMessage());
			
		}
		
	}

}
