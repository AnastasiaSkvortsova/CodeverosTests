package steps;

import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import utilities.DriverCreator;
import utilities.Driver_Factory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SetupSteps {

    WebDriver driver;

    @Before
        public void initialize(){

        String driverName = "firefox";
        if(Driver_Factory.getDriverInstance() == null){
            driver = DriverCreator.createWebDriverInstance(driverName);
            Driver_Factory.addDriverInstance(driver);
        }
        else {driver = Driver_Factory.getDriverInstance();}
        driver.get("http://localhost:80/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    @AfterMethod
    public void getScreenshot(ITestResult result) {

        String path = "/Users/anaskvortsova/Documents/PilotProjects/fundamentals-of-selenium/TestingCodeveros";
        String testName = result.getName();

        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(path+result+".png");
            FileUtils.copyFile(screenshotFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

