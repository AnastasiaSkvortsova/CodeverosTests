package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasicPage {

    protected WebDriver driver;

    public BasicPage(WebDriver driver){

        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 10 seconds Implicit Wait
}

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void navigate (String url){
        driver.get(url);
    }

}
