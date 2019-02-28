package me.manzhos.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class TestBase {

    Properties properties = new Properties();
    private String url;

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
      //  FileInputStream file = new FileInputStream("target/classes/config.properties");
      //  Properties prop = new Properties();
      //  prop.load(file);
//
    //    Configuration.timeout = Integer.valueOf(prop.getProperty("wait.time"));
          Configuration.baseUrl = getURL();


//        if (System.getProperty("browser.type").equalsIgnoreCase("chrome")) {
//            DesiredCapabilities cap2 = DesiredCapabilities.chrome();
//            System.setProperty("webdriver.gecko.driver", prop.getProperty("chrome.driver.path"));
//            cap2.setCapability("screen-resolution", "1920x1080");
//        }
//        if (properties.getProperty("browser.type").equalsIgnoreCase("firefox")) {
//            DesiredCapabilities cap = DesiredCapabilities.firefox();
//            System.setProperty("webdriver.gecko.driver", prop.getProperty("ffdriver.path"));
//
//            FirefoxProfile profile = new FirefoxProfile(new File(prop.getProperty("profile.path")));
//            cap.setCapability(FirefoxDriver.PROFILE, profile);
//            cap.setCapability("screen-resolution", "1920x1080");
//
//            driver = new FirefoxDriver(cap);
//            WebDriverRunner.setWebDriver(driver);
//        }
//        if (prop.getProperty("browser.type").equalsIgnoreCase("grid")) {
//            DesiredCapabilities cap = DesiredCapabilities.firefox();
//            System.setProperty("webdriver.gecko.driver", prop.getProperty("ffdriver.path"));
//            FirefoxProfile profile = new FirefoxProfile(new File(prop.getProperty("profile.path")));
//            cap.setCapability(FirefoxDriver.PROFILE, profile);
//
//            RemoteWebDriver driver;
//            driver = new RemoteWebDriver(new URL(prop.getProperty("hub.url")), cap);
//            driver.setFileDetector(new LocalFileDetector());
//            String sessionId = driver.getSessionId().toString();
//            String videoURL = "http://selenium-hub:8080/grid/resources/remote?session=" + sessionId;
//            System.out.println("live, then video recording can be viewed @ " + videoURL);
//        }
//
//        WebDriverRunner.getWebDriver().manage().window().maximize();
//    }
//
//    @AfterClass
//    protected void tearDown() {
//        if (driver != null) {
//            close();
//        }
//    }
    }
}
