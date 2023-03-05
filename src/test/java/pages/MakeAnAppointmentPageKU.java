package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MakeAnAppointmentPageKU {
    public MakeAnAppointmentPageKU() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "phone")
    public WebElement phone;

    @FindBy(id = "appoDate")
    public WebElement appoDate;


    @FindBy(id = "register-submit")
    public WebElement sendAnAppointmentRequest;

    @FindBy(xpath = "//*[text()='Appointment date can not be past date!']")
    public WebElement appDateCanNotBePastDate;





}
