package TestContext;

import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestContext {

    private Page page;
    private Properties prop;
    private List<byte[]> screenshot = new ArrayList<>();

    public Page getPage(){
        return page;
    }

    public void setPage(Page page){
        this.page=page;
    }

    public Properties getProperty(){
        return prop;
    }

    public void setProperty(Properties prop){
        this.prop=prop;
    }

    public List<byte[]> getScreenshot(){
        return screenshot;
    }

    public void addScreenshot(byte[] screenshots){
        screenshot.add(screenshots);
    }

    public void clearScreenshot(){
        screenshot.clear();
    }


}
