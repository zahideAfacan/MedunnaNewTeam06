package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US17_UserPage {

    public US17_UserPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"account-menu\"]")
    public WebElement signinSymbol;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signinButton;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "(//*[.='Sign in'])[4]")
    public WebElement signinWithCredentials;

    @FindBy(xpath = "//*[contains(text(), 'Items&Titles')]")
    public WebElement itemsTitles;

    @FindBy(xpath = "(//*[contains(text(), 'Room')])[1]")
    public WebElement Room;

    @FindBy(xpath = "//*[contains(text(), 'Create a new Room')]")
    public WebElement createAnewRoom;

    @FindBy(xpath = "//*[@id= 'room-roomNumber']")
    public WebElement roomNumber;

    @FindBy(xpath = "//*[@id= 'room-price']")
    public WebElement price;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    public WebElement roomSaveButton;

    @FindBy(xpath = "//*[contains(text(), 'A new Room is created with identifier')]")
    public WebElement roomCreationSuccesMessage;

    @FindBy(xpath = "(//*[contains(text(), 'This field is required.')])[1]")
    public WebElement roomRequiredMessage;

    @FindBy(xpath = "(//*[contains(text(), 'This field is required.')])[2]")
    public WebElement priceRequiredMessage;

    @FindBy(xpath = "//*[@id='room-createdDate']")
    public WebElement createDate;

    @FindBy(xpath = "//*[contains(text(), 'Created Date')]")
    public WebElement createDateTitle;

    @FindBy(xpath = "//*[@id='room-roomType']")
    public WebElement roomTypeDropdown;

    @FindBy(xpath = "//table/tbody/tr[1]/td[7]")
    public WebElement lastCreatedDate;

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]/div/a[2]")
    public WebElement firstEditRoom;

    @FindBy(xpath = "//*[contains(text(), 'A Room is updated with identifier')]")
    public WebElement roomUpdateMessage;

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]/div/a[3]")
    public WebElement firstDeleteRoom;

    //*[@id='jhi-confirm-delete-room']
    @FindBy(xpath = "//*[@id='jhi-confirm-delete-room']")
    public WebElement deletePopUp;

    @FindBy(xpath = "//*[contains(text(), 'A Room is deleted with identifier')]")
    public WebElement roomdeleteMessage;



}
