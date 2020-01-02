package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodeverosHomePage extends BasicPage {

    private String welcomeMessageSelector;

    public CodeverosHomePage(WebDriver driver){
        super(driver);
        welcomeMessageSelector = "//app-root/ng-component[@class='ng-star-inserted']//mat-sidenav-container/mat-sidenav-content[@class='mat-drawer-content mat-sidenav-content']/ng-component[@class='ng-star-inserted']//div[@class='mat-display-2 page-title']";
    }

    public boolean welcomeMessageIsPresented(){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomeMessageSelector)));
        return driver.findElement(By.xpath(welcomeMessageSelector)).isDisplayed();
    }
}
