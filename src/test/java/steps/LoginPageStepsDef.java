package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.CodeverosHomePage;
import objects.LoginPage;
import objects.LoginTab;
import org.testng.Assert;
import utilities.Driver_Factory;

public class LoginPageStepsDef {

    LoginTab loginTab;
    CodeverosHomePage codeverosHomePage;

    @Given("a web browser is at Codeveros Sign In page")
    public void aWebBrowserIsAtCodeverosSignInPage() {

        //System.out.println("LoginPageStepsDef Given" + Thread.currentThread().getName());
        LoginPage loginPage = new LoginPage(Driver_Factory.getDriverInstance());
        loginPage.waitForVisibilityOfLoginTab();
        loginTab = loginPage.goToLoginSection();
    }

    @When("user enters {string} as a Username_")
    public void userEntersAsAUsername_(String userName) {
        loginTab.fillOutUserName(userName);
    }

    @And("user enters {string} as a Password_")
    public void userEntersAsAPassword_(String password) {
        loginTab.fillOutPassword(password);
    }

    @And("user click Sign In button")
    public void userClickSignInButton() {
        loginTab.submitForm();
    }

    @Then("Codeveros home page is shown")
    public void codeverosHomePageIsShown() {
        codeverosHomePage = new CodeverosHomePage(Driver_Factory.getDriverInstance());
        Assert.assertTrue(codeverosHomePage.welcomeMessageIsPresented());
    }

    @Then("Sign In button stays inactive")
    public void signInButtonStaysInactive() {

        Assert.assertFalse(loginTab.getSignInButtonStatus());
    }

    @Then("Failed login message on Codeveros Sign In page is shown")
    public void failedLoginMessageOnCodeverosSignInPageIsShown() {
        Assert.assertTrue(loginTab.failedLoginMessageIsPresented());
    }
}
