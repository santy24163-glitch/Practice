package Utils;

import TestContext.TestContext;
import com.microsoft.playwright.Page;
import org.openqa.selenium.devtools.v141.page.model.Screenshot;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshots {

    TestContext context;

    public Screenshots(TestContext context){
        this.context=context;
    }

    public byte[] screenshots(String Name){

        byte[] scr = context.getPage().screenshot(new Page.ScreenshotOptions().
                setPath(Paths.get("test-output/extentReports/img/"+Name+".png"))
                .setFullPage(true));

        return scr;
    }

}
