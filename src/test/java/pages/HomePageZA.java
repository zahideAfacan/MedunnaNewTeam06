package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePageZA {
    public HomePageZA() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "//input[@name='currentPassword']")
    public WebElement currentPassword;

    @FindBy(xpath = "//input[@name='newPassword']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(linkText = "Password")
    public WebElement dropdownPassword;

    @FindBy(id = "strengthBar")
    public WebElement strengthBar;

    @FindBy(xpath = "//li[@class='point'][1]")
    public WebElement strengthBar1;

    @FindBy(xpath = "//li[@class='point'][2]")
    public WebElement strengthBar2;

    @FindBy(xpath = "//li[@class='point'][3]")
    public WebElement strengthBar3;

    @FindBy(xpath = "//li[@class='point'][4]")
    public WebElement strengthBar4;

    @FindBy(xpath = "//li[@class='point'][5]")
    public WebElement strengthBar5;



}
