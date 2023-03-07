package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffPageMD {
    public StaffPageMD() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
     @FindBy  (xpath = "//*[@id='entity-menu']/a")

    public WebElement myPages;

    @FindBy(xpath = "//*[@id='entity-menu']/div/a[1]")

    public WebElement searchPatient;

@FindBy (xpath = "//input[@name='ssn']")
    public WebElement ssnTextBox;
@FindBy (linkText = "View")
public WebElement view;
    @FindBy (linkText = "Edit")
    public WebElement edit;
    @FindBy (linkText = "Show Appointments")
    public WebElement showAppointments;
  @FindBy (xpath = "//*[@name='firstName']")
    public WebElement firstName;

 @FindBy (xpath = "//*[@name='lastName']")
public WebElement lastName;
 @FindBy(xpath = "//*[@name='birthDate']")
    public WebElement birthDate;
 @FindBy (xpath = "//*[@name='email']")
    public WebElement email;
@FindBy(xpath = "//*[@name='phone']")
    public WebElement phone;
@FindBy(xpath = "//*[@name='gender']")
    public WebElement gender;
@FindBy (xpath = "//*[@name='bloodGroup']")
    public WebElement bloodGroup;
@FindBy (xpath = "//*[@name='adress']")
    public WebElement address;
@FindBy(xpath = "//textarea[@name='description']")
    public WebElement description;
@FindBy (xpath = "//*[@name='country.id']")
    public WebElement patientCountry;
@FindBy (xpath = "//*[@name='cstate.id']")
    public WebElement patientStateCity;
@FindBy(id = "save-entity")
    public WebElement save;

///////VERIFICATION PAGE\\\\\\
    @FindBy(xpath = "//*[@id='app-view-container']//dd[1]")
    public WebElement ssnUpdated;
    @FindBy(xpath = "//*[@id='app-view-container']//dd[2]")
public WebElement firstNameUpdated;
    @FindBy(xpath = "//*[@id='app-view-container']//dd[3]")
    public WebElement lastNameUpdated;
    @FindBy(xpath = "//*[@id='app-view-container']//dd[5]")
    public WebElement emailUpdated;
    @FindBy(xpath = "//*[@id='app-view-container']//dd[8]")
    public WebElement addressUpdated;
    @FindBy(xpath = "//*[@id='app-view-container']//dd[9]")
    public WebElement descriptionUpdated;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement saveAlert;

}
