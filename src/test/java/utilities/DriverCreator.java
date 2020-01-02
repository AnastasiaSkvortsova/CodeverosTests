package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverCreator {

    public static WebDriver createWebDriverInstance(String webDriverName){

        if (webDriverName.equalsIgnoreCase("chrome")) {
            return DriverManager.getChromeDriver();
        }
        if (webDriverName.equalsIgnoreCase("firefox")) {
            return DriverManager.getFirefoxDriver();
        }

        return DriverManager.getChromeDriver();
    }
}
