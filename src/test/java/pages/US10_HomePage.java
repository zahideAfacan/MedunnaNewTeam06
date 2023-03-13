package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class
US10_HomePage {

    public US10_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@id=\"account-menu\"]/a")
    public WebElement signInClickIcon;

    @FindBy(linkText = "Sign in")
    public WebElement signInLink;





}