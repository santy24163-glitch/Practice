package Hooks;

import PlaywrightFactory.PlaywrightFactory;
import TestContext.TestContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.*;

import java.io.File;
import java.util.List;

public class Hooks {





    Page page;
    TestContext context;
    PlaywrightFactory fact;

    public Hooks(TestContext context){
        this.context = context;
    }

    @Before
    public void setup(){

        fact = new PlaywrightFactory();
        context.setProperty(fact.init_Properties());
        context.setPage(fact.init_Playwright(context.getProperty().getProperty("browser")));
    }

    @After
    public void tearDown(){
        context.getPage().context().browser().close();
    }

    @AfterStep
    public void screenshots(Scenario scenario){

        List<byte[]> screenshot = context.getScreenshot();
        for(byte[] scrr: screenshot){

            scenario.attach(scrr, "image/png", "TestStep Screenshots");
        }
        context.clearScreenshot();

        if(scenario.isFailed()){
            byte[] scr = context.getPage().screenshot(new Page.ScreenshotOptions().setFullPage(true));
            scenario.attach(scr,"image/png", "Failed Screenshot");
        }

    }

    @BeforeAll
    public static void cleanOldScreenshots() {

        File screenshotDir = new File("test-output/extentReports/img");

        if (screenshotDir.exists()) {
            for (File file : screenshotDir.listFiles()) {
                file.delete();
            }
        }
    }
}
