package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RegistrationTab extends BasicPage{

    private WebElement firstNameInput;
    private WebElement lastNameInput;
    private WebElement userNameInput;
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement confirmPasswordInput;
    private WebElement registerButton;
    public String registrationPageUrl;
    private By firstNameSelector;
    private WebElement welcomeMessage;
    private By welcomeMessageSelector;

    public RegistrationTab(WebDriver driver){

        super(driver);

        registrationPageUrl = "localhost:80/";
        firstNameSelector = By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form/div/mat-form-field[1]//input");
    }

    public void fillOutFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void fillOutLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void fillOutUserName(String userName){
        userNameInput.sendKeys(userName);
    }

    public void fillOutEmail(String email){
        emailInput.sendKeys(email);
    }

    public void fillOutPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void fillOutConfirmPassword(String password){
        confirmPasswordInput.sendKeys(password);
    }

    public void submitForm(){
        registerButton.submit();
    }

    public boolean getRegisterButtonStatus(){
        return registerButton.isEnabled();
    }

    public void initOnceVisible (){

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(firstNameSelector));
        firstNameInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form/div/mat-form-field[1]//input"));
        lastNameInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form/div/mat-form-field[2]//input"));
        userNameInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form/div/mat-form-field[3]//input"));
        emailInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form/div/mat-form-field[4]//input"));
        passwordInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form/div/mat-form-field[5]//input"));
        confirmPasswordInput = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form/div/mat-form-field[6]//input"));
        registerButton = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form//button[@type='submit']"));
    }


}
