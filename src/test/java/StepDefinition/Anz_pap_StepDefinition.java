package StepDefinition;

import PageClass.HomePage;
import PageClass.LoginPage;
import TestContext.TestContext;
import Utils.Screenshots;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class Anz_pap_StepDefinition {

    TestContext context;
    LoginPage login;
    Properties prop;
    HomePage home;
    Screenshots screenshot;
    public Anz_pap_StepDefinition(TestContext context){

        this.context=context;
        prop = context.getProperty();
        screenshot = new Screenshots(context);
    }
    @Given("User is in HomPage")
    public void userIsInHomPage() {

    }

    @When("Enters BA Username and Password")
    public void entersBAUsernameAndPassowrd() {
        login = new LoginPage(context.getPage());
        login.entering_Username(prop.getProperty("BAUsername"));
        login.entering_Password(prop.getProperty("BAPassword"));
    }

    @And("Clicks on login")
    public void clicksOnLogin() {

        home = login.clicking_On_Login();
    }

    @Then("User should be navigated inside ANZ_PAP Portal")
    public void userShouldBeNavigatedInsideANZ_PAPPortal() {


    }

    @And("Logo should be displayed correctly")
    public void logoShouldBeDisplayedCorrectly() {

        String src = home.logoVerification();
        context.addScreenshot(screenshot.screenshots("Logo"));
        Assert.assertTrue(src.contains("astrazeneca-logo-2.png"));

    }

    @When("i Logged into PAP Application using BA as a user")
    public void iLoggedIntoPAPApplicationUsingBAAsAUser() {

        login = new LoginPage(context.getPage());
        login.entering_Username(prop.getProperty("BAUsername"));
        login.entering_Password(prop.getProperty("BAPassword"));

        home = login.clicking_On_Login();

        context.addScreenshot(screenshot.screenshots("BA Login"));
        home.clickingOnLogout();

    }

    @And("I navigate to login to with the Henry Williams user")
    public void iNavigateToLoginToWithTheHenryWilliamsUser() {

        login.entering_Username(prop.getProperty("HCPUsername"));
        login.entering_Password(prop.getProperty("HCPPassword"));

        home = login.clicking_On_Login();

        context.addScreenshot(screenshot.screenshots("HCP Login"));

    }

    @Then("all the users should be navigated inside AZ Company Portal")
    public void allTheUsersShouldBeNavigatedInsideAZCompanyPortal() {

        System.out.println("Successfully logged in as HCP");
    }
}
