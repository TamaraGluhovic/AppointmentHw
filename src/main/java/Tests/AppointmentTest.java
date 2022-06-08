package Tests;

import model.AppointmentData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SummaryPage;

import java.time.Duration;

public class AppointmentTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    /*
     * Mogući podaci za facility su:
     * - Tokyo CURA Healthcare Center
     * - Hongkong CURA Healthcare Center
     * - Seoul CURA Healthcare Center
     *
     * Mogući podaci za healthCareProgram:
     * - Medicare
     * - Medicaid
     * - None
     * */
    private final AppointmentData appointmentData = new AppointmentData(
            "Hongkong CURA Healthcare Center",
            true,
            "Medicaid",
            "30/07/2022",
            "Test");


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tamara\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait, appointmentData);
        summaryPage = new SummaryPage(driver, driverWait);

        driver.manage().window().maximize();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test(priority = 1)
    public void loginTest() {
        homePage.openLoginPage();
        loginPage.setUsername("John Doe");
        loginPage.setPassword("ThisIsNotAPassword");
        loginPage.login();
        Assert.assertTrue(appointmentPage.isFormPresent());
    }

    @Test(priority = 2)
    public void makeAnAppointmentTest() {
        appointmentPage.makeAnAppointment();
        AppointmentData resultAppointmentData = summaryPage.parseSummaryData();
        Assert.assertTrue(this.appointmentData.dataIsSameAs(resultAppointmentData));
    }



    @AfterClass
    public void afterClass() {
        driver.close();
    }
}

