package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MessagePageMD {
    public  MessagePageMD(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//input[@name='name']")
    public WebElement contactNameSurname;
    @FindBy (xpath = "//input[@name='email']")
    public WebElement contactEmail;
    @FindBy (xpath = "//input[@name='subject']")
    public WebElement contactSubject;
    @FindBy (id = "message")
    public WebElement contactMessage;
   @FindBy (xpath = " //button[@type='submit']")
    public WebElement mesageSubmit;
@FindBy(xpath = "//span[.='CONTACT']")
    public WebElement contact;
@FindBy (xpath = "//div[@role='alert']")
public WebElement successMessage;


}
