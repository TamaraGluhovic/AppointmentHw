package pages;

import model.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    private By openLoginPageButton = By.id("btn-make-appointment");


    public HomePage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait);
    }

    public void openLoginPage(){
        getDriver().findElement(openLoginPageButton).click();
    }



}
