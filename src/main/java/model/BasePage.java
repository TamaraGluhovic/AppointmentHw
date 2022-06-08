package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {


    private WebDriver driver;
    private WebDriverWait driverWait;

    public BasePage(WebDriver webDriver, WebDriverWait driverWait) {
        this.driver = webDriver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public void setDriverWait(WebDriverWait driverWait) {
        this.driverWait = driverWait;
    }
}
