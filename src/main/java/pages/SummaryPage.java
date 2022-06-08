package pages;

import model.AppointmentData;
import model.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {
    private AppointmentData appointmentData;
    private final By selectedFacility = By.xpath("//*[@id=\"facility\"]");
    private final By appliedForHospitalReadmission = By.xpath("//*[@id=\"hospital_readmission\"]");
    private final By healthCareProgram = By.xpath("//*[@id=\"program\"]");
    private final By appointmentDate = By.xpath("//*[@id=\"visit_date\"]");
    private final By appointmentNote = By.xpath("//*[@id=\"comment\"]");

    public SummaryPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait);
        appointmentData = new AppointmentData();
    }

    public AppointmentData parseSummaryData() {
        parseSelectedFacility();
        parseAppliedForReadmission();
        parseHealthCareProgram();
        parseAppointmentDate();
        parseAppointmentNote();
        return appointmentData;
    }

    private void parseSelectedFacility() {
        this.appointmentData.setFacility(getDriver().findElement(selectedFacility).getText());
    }

    private void parseAppliedForReadmission() {
        String result = getDriver().findElement(appliedForHospitalReadmission).getText();

        this.appointmentData.setApplyForHospitalReadmission(result.equals("Yes"));
    }

    private void parseHealthCareProgram() {
        this.appointmentData.setHealthCareProgram(getDriver().findElement(healthCareProgram).getText());
    }

    private void parseAppointmentDate() {
        this.appointmentData.setAppointmentDate(getDriver().findElement(appointmentDate).getText());
    }

    private void parseAppointmentNote() {
        this.appointmentData.setAppointmentNote(getDriver().findElement(appointmentNote).getText());
    }

}
