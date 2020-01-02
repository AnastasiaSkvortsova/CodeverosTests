package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;
import objects.CodeverosHomePage;
import objects.LoginPage;
import objects.RegistrationTab;
import org.testng.Assert;
import utilities.Driver_Factory;

import java.time.LocalDateTime;

@CucumberOptions(features = "features")
public class AccountRegistrationStepsDef {

    RegistrationTab registrationTab;
    CodeverosHomePage codeverosHomePage;

    @Given("a web browser is at the Codeveros registration page")
    public void aWebBrowserIsAtTheCodeverosRegistrationPage() {

       // System.out.println("AccountRegistrationStepsDef Given " + Thread.currentThread().getName());
        LoginPage loginPage = new LoginPage(Driver_Factory.getDriverInstance());
        loginPage.waitForVisibilityOfRegTab();
        registrationTab = loginPage.goToRegistrationSection();
    }

    @When("user enters {string} as a First Name")
    public void userEntersFirstName(String firstName) {
        System.out.println("AccountRegistrationStepsDef And " + firstName + " " + Thread.currentThread().getName());
        registrationTab.fillOutFirstName(firstName);
    }

    @And("user enters {string} as a Second Name")
    public void userEntersSecondName(String lastName) {
        registrationTab.fillOutLastName(lastName);
    }

    @And("user enters unique Username")
    public void userEntersUniqueUsername() {
        registrationTab.fillOutUserName(LocalDateTime.now().toString());
        System.out.println(LocalDateTime.now().toString());
    }

    @And("user enters {string} as a Username")
    public void userEntersUsername(String userName) {
        registrationTab.fillOutUserName(userName);
    }

    @And("user enters {string} as a Email Address")
    public void userEnterEmailAddress(String email) {
        registrationTab.fillOutEmail(email);
    }

    @And("user enters {string} as a Password")
    public void userEntersPassword(String password) {
        registrationTab.fillOutPassword(password);
    }

    @And("user enters {string} as a Confirm Password")
    public void userEntersConfirmPassword(String confPassword) {
        registrationTab.fillOutConfirmPassword(confPassword);
    }

    @And("user click Register button")
    public void userClickRegisterButton() {
        registrationTab.submitForm();
    }

    @Then("Codeveros welcome page is shown")
    public void codeverosWelcomePageIsShown() {
        codeverosHomePage = new CodeverosHomePage(Driver_Factory.getDriverInstance());
        Assert.assertTrue(codeverosHomePage.welcomeMessageIsPresented());
    }

    @Then("the Register button stays inactive")
    public void theRegisterButtonStaysInactive() {
        System.out.println("AccountRegistrationStepsDef Then " + Thread.currentThread().getName());
        Assert.assertFalse(registrationTab.getRegisterButtonStatus());
    }
}
