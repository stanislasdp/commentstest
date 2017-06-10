package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class WebDriverUtils {

    private static WebDriver driver;
    private static final int implicitlyWaitTimeOut = 3;

    private WebDriverUtils() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            Properties property = new Properties();

            try (FileInputStream fileInputStream = new FileInputStream("./src/test/resources/Data.properties")) {
                property.load(fileInputStream);
                driver = new RemoteWebDriver(new URL(property.getProperty("webDriverUrl")), DesiredCapabilities.chrome());
                driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeOut, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            } catch (IOException e) {
                throw new RuntimeException("Runtime Exception", e);
            }
        }
        return driver;

    }

    public static int getImplicitlyWaitTimeOut() {
        return implicitlyWaitTimeOut;
    }

    public static void stop() {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }

    public static void OpenUrl(String url) {
        getWebDriver().get(url);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void AlertSwitchTo() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
    }
}
