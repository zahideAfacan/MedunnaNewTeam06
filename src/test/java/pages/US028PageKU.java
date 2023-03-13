package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US028PageKU {
    public US028PageKU(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "entity-menu")
    public WebElement itemsTitlesIcon;

    @FindBy(linkText = "Messages")
    public WebElement messagesButton;


    @FindBy(id= "c-message-heading")
    public WebElement messagesPortal;

    @FindBy(xpath = "//*[.='Name']")
    public WebElement authors;

    @FindBy(xpath = "//*[.='Email']")
    public WebElement emails;

    @FindBy(xpath = "//*[.='Message']")
    public WebElement messages;



    @FindBy(linkText = "Create a new Message")
    public WebElement createmessage;

    @FindBy(name= "name")
    public WebElement mname;

    @FindBy(name= "email")
    public WebElement memail;

    @FindBy(name= "subject")
    public WebElement msubject;

    @FindBy(name= "message")
    public WebElement mmessage;

    @FindBy(id= "save-entity")
    public WebElement msaveButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement malertPath;

    @FindBy(xpath = "//*[@class='hand']//*[.='ID']")
    public WebElement mID;
    @FindBy(xpath = "(//*[.='Edit'])[1]")
    public WebElement medit;

    @FindBy(xpath = "(//*[.='Delete'])[1]")
    public WebElement mdelete;


    @FindBy(id= "jhi-confirm-delete-cMessage")
    public WebElement mconfirmDelete;












}
