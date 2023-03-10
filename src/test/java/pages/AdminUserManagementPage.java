package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminUserManagementPage {
    public AdminUserManagementPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Administration")
    public WebElement Administration;

    @FindBy(linkText = "User management")
    public WebElement UserManagement;

    @FindBy(linkText = "Create a new user")
    public WebElement CreateANewUser;

    @FindBy(id = "login")
    public WebElement Login;

    @FindBy(id = "firstName")
    public WebElement FirstName;

    @FindBy(id = "lastName")
    public WebElement LastName;

    @FindBy(id = "email")
    public WebElement Email;

    @FindBy(id = "ssn")
    public WebElement SSN;

    @FindBy(id = "langKey")
    public WebElement Language;

    @FindBy(xpath = "//option[@value='ROLE_PATIENT']")
    public WebElement Profiles;

    @FindBy(xpath = "//div[@class='form-check']")
    public WebElement ActivatedCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement Save;

    @FindBy(xpath = "(//a[@class='page-link'])[9]")
    public WebElement LastPageButton;

    @FindBy(xpath = "//tr/td/a")
    public WebElement ListOfPatientID;

    @FindBy(xpath = "//tr/td/a")
    public WebElement ListOfPatientInfo;




}
