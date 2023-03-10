package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPageZA {
    public LoginPageZA() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id ="account-menu")
    public WebElement userIcon;

    @FindBy(linkText = "Sign in")
    public WebElement SigIn;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='rememberMe']")
    public WebElement rememberMe;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

}
