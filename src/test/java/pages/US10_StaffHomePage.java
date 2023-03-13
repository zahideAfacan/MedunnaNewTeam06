package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US10_StaffHomePage {
    public US10_StaffHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesLink;
    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientLink;

}
