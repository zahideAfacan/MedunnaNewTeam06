package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US023Page {

    public US023Page () {
        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy(xpath = "(//a[@class='btn btn-warning btn-sm'])[1]")
        public WebElement showAppButton;

        @FindBy(linkText = "Show Tests")
        public WebElement ShowTests;

        @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[1]")
        public WebElement ViewResult;

        @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
        public WebElement EditButton;

        @FindBy(id = "c-test-result-result")
        public WebElement Result;

        @FindBy(id = "save-entity")
        public WebElement Save;

        @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
        public WebElement identifier;

        @FindBy(linkText = "Result")
        public WebElement ResultCell;

        @FindBy(linkText = "Date")
        public WebElement DateCell;

        @FindBy(linkText = "Description")
        public WebElement Description;

}
