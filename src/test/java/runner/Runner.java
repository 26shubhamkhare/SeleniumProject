package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},features="features",
glue="stepdefinitions", tags= {"@Tableware"})
public class Runner {	

	@AfterClass
	public static void setup() {
		String projectPath = System.getProperty("user.dir");
		String extentConfigFilePath = projectPath+"//src//test//java//extent-config.xml";
		File extentConfigFile = new File(extentConfigFilePath);
		Reporter.loadXMLConfig(extentConfigFile);
		
	//Reporter.loadXMLConfig(new File("C:\\CapgSprint2\\TableWareOrdering\\src\\test\\java\\extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Shubham Khare");
	Reporter.setSystemInfo("Application Name", "TheIndusValley");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Test Environment");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	}

