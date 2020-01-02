package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {

    public static ChromeDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        return new ChromeDriver();
    }

    public static FirefoxDriver getFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette",true);
        return new FirefoxDriver(capabilities);
    }
}
