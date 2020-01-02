package utilities;

import com.comcast.pantry.run.Run;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver_Factory {

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal();

    private static List<WebDriver> driversList = Collections.synchronizedList(new ArrayList());

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                for(WebDriver i: driversList){
                    i.quit();
                }
            }
        });
    }

    public static void addDriverInstance (WebDriver webDriverInstance){
        WEB_DRIVER_THREAD_LOCAL.set(webDriverInstance);
        driversList.add(webDriverInstance);
    }


    public static WebDriver getDriverInstance (){
        return (WebDriver) WEB_DRIVER_THREAD_LOCAL.get();
    }

}
