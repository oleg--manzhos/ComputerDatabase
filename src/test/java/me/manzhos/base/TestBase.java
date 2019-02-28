package me.manzhos.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class TestBase {

    Properties properties = new Properties();
    private String url;

    //get application URL from config file
    protected String getURL() {
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("environment.properties"));
            url = properties.getProperty("url");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return url;
    }

    @BeforeClass
    public void setUp() throws Exception {

        Configuration.baseUrl = getURL();
        open(getURL());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterClass
    protected void tearDown() {
        Selenide.close();
    }
}
