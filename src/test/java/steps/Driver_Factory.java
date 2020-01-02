package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver_Factory {

    private static ChromeDriver chromeDriverInstance;
    private static FirefoxDriver firefoxDriverInstance;
    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal();


    public static ChromeDriver getChromeDriverInstance(){
        if (chromeDriverInstance == null){
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
            chromeDriverInstance = new ChromeDriver();
            WEB_DRIVER_THREAD_LOCAL.set(chromeDriverInstance);
        }
        return (ChromeDriver) WEB_DRIVER_THREAD_LOCAL.get();
    }

    public static FirefoxDriver getFirefoxDriverInstance(){
        if(firefoxDriverInstance == null){
            System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette",true);
            firefoxDriverInstance = new FirefoxDriver(capabilities);
            WEB_DRIVER_THREAD_LOCAL.set(chromeDriverInstance);
        }
        return (FirefoxDriver) WEB_DRIVER_THREAD_LOCAL.get();
    }
}
