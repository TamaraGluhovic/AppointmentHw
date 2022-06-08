package pages;

import model.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private  By usernameInput = By.xpath("//*[@id=\"txt-username\"]");
    private  By passwordInput = By.xpath("//*[@id=\"txt-password\"]");
    private  By loginButton = By.xpath("//*[@id=\"btn-login\"]");

    public LoginPage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }

    public void setUsername(String username) {
        getDriver().findElement(this.usernameInput).sendKeys(username);
    }

    public void setPassword(String password) {
        getDriver().findElement(this.passwordInput).sendKeys(password);
    }

    public void login() {
        getDriver().findElement(loginButton).click();
    }


}
