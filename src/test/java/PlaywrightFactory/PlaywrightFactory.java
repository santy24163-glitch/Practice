package PlaywrightFactory;

import TestContext.TestContext;
import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Page page;
    TestContext context;
    Browser browser;
    BrowserContext browserContext;
    Playwright playwright;
    Properties prop;

    public Page init_Playwright(String Browser){

        playwright = Playwright.create();

        switch (Browser.toLowerCase()){
            case "chromium":{

                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                browserContext = browser.newContext();
            }
            case "firefox":{

                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                browserContext = browser.newContext();
            }
            case "chrome":{

                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                browserContext = browser.newContext();
            }
            case "internet explorer":{

                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                browserContext = browser.newContext();
            }

        }
            page = browserContext.newPage();
            page.navigate("https://www.accessaz-uat.com.au");

            return page;

    }

    public Properties init_Properties(){

        prop = new Properties();
        FileInputStream ip = null;
        try {

            ip = new FileInputStream("./src/test/resources/config.properties");
            prop.load(ip);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

}
