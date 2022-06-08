package pages;

import model.AppointmentData;
import model.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppointmentPage extends BasePage {

    private AppointmentData appointmentData;
    private final By facilitySelect = By.xpath("//*[@id=\"combo_facility\"]");
    private final By applyForHospitalReadmissionCheckBox = By.xpath("//*[@id=\"chk_hospotal_readmission\"]");
    private final By appointmentDateSelector = By.xpath("//*[@id=\"txt_visit_date\"]");
    private final By appointmentNoteInput = By.xpath("//*[@id=\"txt_comment\"]");
    private final By bookAppointmentButton = By.xpath("//*[@id=\"btn-book-appointment\"]");


    private WebElement facilitySelectElement;
    private WebElement applyForHospitalReadmissionCheckBoxElement;
    private WebElement healthCareProgramElement;
    private WebElement appointmentDateSelectorElement;
    private WebElement appointmentNoteInputElement;
    private WebElement bookAppointmentButtonElement;


    public AppointmentPage(WebDriver webDriver, WebDriverWait driverWait, AppointmentData appointmentData) {
        super(webDriver, driverWait);
        this.appointmentData = appointmentData;
    }



    public boolean isFormPresent(){
        return !getDriver().findElements(By.id("appointment")).isEmpty();
    }

    private void setWebElements() {
        facilitySelectElement = getDriver().findElement(facilitySelect);
        applyForHospitalReadmissionCheckBoxElement = getDriver().findElement(applyForHospitalReadmissionCheckBox);
        appointmentDateSelectorElement = getDriver().findElement(this.appointmentDateSelector);
        healthCareProgramElement = getDriver().findElement(By.xpath("//*[@name='programs'][@value='" + this.appointmentData.getHealthCareProgram() + "']"));
        appointmentNoteInputElement = getDriver().findElement(appointmentNoteInput);
        bookAppointmentButtonElement = getDriver().findElement(bookAppointmentButton);
    }


    public void makeAnAppointment() {
        setWebElements();

        //selectFacility();
        selectFacilityByName(this.appointmentData.getFacility());
        applyForHospitalReadmission(this.appointmentData.isApplyForHospitalReadmission());
        selectHealthCareProgram(this.appointmentData.getHealthCareProgram());
        setAppointmentDate(this.appointmentData.getAppointmentDate());
        setAppointmentNote(this.appointmentData.getAppointmentNote());

        getDriver().findElement(bookAppointmentButton).click();
    }
    private void selectFacility() {
        //WebElement facilities =  getDriver().findElement(facilitySelect);
        Select select = new Select(facilitySelectElement);
        select.selectByIndex(2);
    }

    private void selectFacilityByName(String facilityName) {
        //WebElement facilities =  getDriver().findElement(facilitySelect);
        Select select = new Select(facilitySelectElement);
        select.selectByVisibleText(facilityName);
    }

    public String getCurrentlySelectedFacility() {
        Select select = new Select(facilitySelectElement);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    private void applyForHospitalReadmission(boolean apply) {
        //WebElement applyCheckbox = getDriver().findElement(applyForHospitalReadmissionCheckBox);
        if (apply) {
            applyForHospitalReadmissionCheckBoxElement.click();
        }
    }

    public boolean getCurrentlyAppliedState() {
        return applyForHospitalReadmissionCheckBoxElement.isSelected();
    }

    private void selectHealthCareProgram(String radioInputValue) {
        /*WebElement healthCareProgramRadioButton = getDriver().findElement(
                By.xpath("//*[@name='programs'][@value='" + radioInputValue + "']"));*/

        healthCareProgramElement.click();
    }

    public String getCurrentlySelectedHealthCareProgram() {
        List<WebElement> programs = getDriver().findElements(By.name("programs"));
        for (WebElement program : programs) {
            if (program.isSelected()) {
                return program.getAttribute("value");
            }
        }
        return "";
    }



    public void setAppointmentDate(String appointmentDate) {
        //getDriver().findElement(this.appointmentDateSelector).sendKeys(appointmentDate);
        appointmentDateSelectorElement.sendKeys(appointmentDate);
    }

    public String getCurrentAppointmentDate() {
        return appointmentDateSelectorElement.getAttribute("value");
    }

    public void setAppointmentNote(String appointmentNote) {
        //getDriver().findElement(appointmentNoteInput).sendKeys(appointmentNote);
        appointmentNoteInputElement.sendKeys(appointmentNote);
    }

    public String getCurrentAppointmentNote() {
        return appointmentNoteInputElement.getAttribute("value");
    }

    public WebElement getFacilitySelectElement() {
        return facilitySelectElement;
    }

    public WebElement getApplyForHospitalReadmissionCheckBoxElement() {
        return applyForHospitalReadmissionCheckBoxElement;
    }

    public WebElement getHealthCareProgramElement() {
        return healthCareProgramElement;
    }

    public WebElement getAppointmentDateSelectorElement() {
        return appointmentDateSelectorElement;
    }

    public WebElement getAppointmentNoteInputElement() {
        return appointmentNoteInputElement;
    }

    public WebElement getBookAppointmentButtonElement() {
        return bookAppointmentButtonElement;
    }

}
