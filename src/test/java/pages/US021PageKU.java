package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US021PageKU {
    public US021PageKU(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "admin-menu")
    public WebElement administrationIcon;

    @FindBy(linkText = "User management")
    public WebElement userManagement;


    @FindBy(xpath = "(//*[.='Created date'])[2]")
    public WebElement createdDate;

    @FindBy(xpath = "//*[.='›']")
    public WebElement nextPage;

    @FindBy(xpath = "//*[.='First name']")
    public WebElement seeFirstName;

    @FindBy(xpath = "//*[.='Last name']")
    public WebElement seeLastName;

    @FindBy(xpath = "//*[.='Email']")
    public WebElement seeEmail;

    @FindBy(xpath = "//*[.='Language']")
    public WebElement seeLanguage;

    @FindBy(xpath = "//*[.='Login']")
    public WebElement seeUserName;

    @FindBy(id = "activated")
    public WebElement activated;

    @FindBy(id = "authorities")
    public WebElement roles;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement saveButton;

    @FindBy(id = "modified-date-sort")
    public WebElement modifiedDate;

    @FindBy(xpath = "//*[@id='hastabey']//*[@class='badge badge-info']")
    public WebElement userVerified;



    @FindBy(xpath = "//*[@id='account-menu']/a")
    public WebElement dregisterIcon;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement dregisterButton;

    @FindBy(id = "ssn")
    public WebElement dssnBox;


    @FindBy(id = "firstName")
    public WebElement dfirstNameBox;


    @FindBy(id = "lastName")
    public WebElement dlastNameBox;


    @FindBy(id = "username")
    public WebElement dusername;


    @FindBy(id = "email")
    public WebElement demail;

    @FindBy(name = "firstPassword")
    public WebElement dpassword;


    @FindBy(name= "secondPassword")
    public WebElement dconfirmPassword;

    @FindBy(id = "register-submit")
    public WebElement dregister;


    @FindBy(xpath = "//*[@id='kobaykullanici']//*[contains(text(),'Delete')]")
    public WebElement userDelete;

    @FindBy(xpath = "//*[@class='btn btn-danger']//*[contains(text(),'Delete')]")
    public WebElement userConfirmDelete;

    @FindBy(xpath = "//*[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement alertPath;













}
