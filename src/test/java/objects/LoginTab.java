package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTab extends BasicPage {

    private WebElement userNameInput;
    private WebElement passwordInput;
    private WebElement signInButton;
    private By userNameSelector;
    public String loginPageUrl;
    private String failedLoginMessageSelector;

    public LoginTab(WebDriver driver){
        super(driver);

        loginPageUrl = "localhost:80/";
        userNameSelector = By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[1]//auth-login[@class='ng-star-inserted']/form/div/mat-form-field[1]//input");
        failedLoginMessageSelector = "//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[1]//auth-login[@class='ng-star-inserted']/form[@class='ng-dirty ng-touched ng-valid']//p[.='Failed login']";
    }

    public void fillOutUserName(String userName){
        userNameInput.sendKeys(userName);
    }

    public void fillOutPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void submitForm(){
        signInButton.submit();
        signInButton.submit();
    }

    public boolean getSignInButtonStatus(){
        return signInButton.isEnabled(); }

    public boolean failedLoginMessageIsPresented(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(failedLoginMessageSelector)));
        return driver.findElement(By.xpath(failedLoginMessageSelector)).isDisplayed();
    }

    public void initOnceVisible () {

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(userNameSelector));
        userNameInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[1]//auth-login[@class='ng-star-inserted']/form/div/mat-form-field[1]//input"));
        passwordInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[1]//auth-login[@class='ng-star-inserted']/form/div/mat-form-field[2]//input"));
        signInButton = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[1]//auth-login[@class='ng-star-inserted']/form//button[@type='submit']"));
    }
}
