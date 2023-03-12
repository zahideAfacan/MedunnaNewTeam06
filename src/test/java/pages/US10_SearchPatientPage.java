package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US10_SearchPatientPage {
    public US10_SearchPatientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "ssn")
    public WebElement ssnBox;
    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;
}