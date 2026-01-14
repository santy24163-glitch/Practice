package PageClass;

import com.microsoft.playwright.Page;

public class HomePage {

    private String Logo = "span.logoAlign img";
    private String Logout = "//li[@id='logoutbtn']";
    private Page page;

    public HomePage(Page page){
        this.page=page;
    }

    public String logoVerification(){
        String img = page.locator(Logo).first().getAttribute("src");
        return img;
    }

    public void clickingOnLogout(){
        page.click(Logout);
    }


}
