package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US016Page {

    public US016Page () {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[.='Created date'])[2]")
    public WebElement CreatedDate;

    @FindBy(xpath = "//*[.='›']")
    public WebElement NextPage;

    @FindBy(xpath = "//*[.='First name']")
    public WebElement SeeFirstName;

    @FindBy(xpath = "//*[.='Last name']")
    public WebElement SeeLastName;

    @FindBy(xpath = "//*[.='Email']")
    public WebElement SeeEmail;

    @FindBy(xpath = "//*[.='Language']")
    public WebElement SeeLanguage;

    @FindBy(xpath = "//*[.='Login']")
    public WebElement SeeUserName;
}
