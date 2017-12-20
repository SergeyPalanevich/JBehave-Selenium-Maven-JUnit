package com.epam.bdd.core.drivers;

import com.epam.bdd.core.exeptions.NoSuchWebDriverExeption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static com.epam.bdd.core.utils.LoggerUtils.info;
import static com.epam.bdd.core.utils.PropertiesUtils.readProperties;

public class DriverManager {

    public static final long MANAGE_TIMEOUT = 45;
    private static final String INFO_MSG = "Driver type is ";
    private static final String ERROR_MSG = "Invalid name for WebDriver...";
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() throws NoSuchWebDriverExeption {

        String driverType = readProperties();

        if (driver == null) {
            if (driverType == null) {
                info(INFO_MSG + "CHROME by Default");
                driver = new ChromeDriverCreator().createDriver();
                setDriverManage();
                return driver;
            } else {
                switch (driverType.toUpperCase()) {
                    case "CHROME":
                        info(INFO_MSG + "CHROME");
                        driver = new ChromeDriverCreator().createDriver();
                        setDriverManage();
                        return driver;
                    case "FIREFOX":
                        driver = new FireFoxDriverCreator().createDriver();
                        setDriverManage();
                        info(INFO_MSG + "FIREFOX");
                        return driver;
                    default:
                        throw new NoSuchWebDriverExeption(ERROR_MSG);
                }
            }
        } else {
            return driver;
        }
    }


    private static void setDriverManage() {
        driver.manage().timeouts().implicitlyWait(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

    public static File takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

}
