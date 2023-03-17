package pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US016_NewPatient {
    public US016_NewPatient () {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "patient-firstName")
    public WebElement patientFirstName;

    @FindBy(id = "patient-lastName")
    public WebElement patientLastName;

    @FindBy(id = "patient-birthDate")
    public WebElement patientBirthDate;

    @FindBy(id = "email")
    public WebElement Email;

    @FindBy(id = "patient-phone")
    public WebElement patientPhone;

    @FindBy(id = "patient-bloodGroup")
    public WebElement patientBloodGroup;

    @FindBy(id = "patient-adress")
    public WebElement patientAdress;

    @FindBy(id = "patient-description")
    public WebElement patientDescription;

    @FindBy(id = "patient-country")
    public WebElement patientCountry;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement creatingAlert;

    @FindBy(xpath = "//*[@id=\"patient-country\"]/option[6]")
    public WebElement USA;

    @FindBy(id = "jhi-confirm-delete-patient")
    public WebElement confirmDelete;

    @FindBy(xpath = "//*[.='›']")
    public WebElement nextPage;






}
