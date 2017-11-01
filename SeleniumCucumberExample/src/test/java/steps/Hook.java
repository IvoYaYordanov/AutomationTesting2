package steps;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializedTest(){

        System.out.println("Open browser");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ivyordanov\\Downloads\\chromedriver_win32\\chromedriver.exe");
        base.driver = new ChromeDriver();
    }
    @After
    public void tearDownTest(Scenario scenario){

        if(scenario.isFailed()){
            //Take a screen shot
            System.out.println(scenario.getName());
        }
        System.out.println("Close browser");
        base.driver.close();
    }
}
