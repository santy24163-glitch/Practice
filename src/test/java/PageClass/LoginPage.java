package PageClass;

import TestContext.TestContext;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class LoginPage {

    private Page page;
    private String Username = "input#username";
    private String Password = "input#password";
    private String Login = "button#customButton";
    Properties prop;
    TestContext context;

    public LoginPage(Page page){

        this.page=page;

    }

    public void entering_Username(String username) {

        page.fill(Username, username);

    }

    public void entering_Password(String password) {

        page.fill(Password, password);
    }

    public HomePage clicking_On_Login() {

        page.click(Login);
        return new HomePage(page);
    }

}
