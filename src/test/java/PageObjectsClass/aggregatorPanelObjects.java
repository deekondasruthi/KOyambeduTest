package PageObjectsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class aggregatorPanelObjects {
    WebDriver driver;
    public aggregatorPanelObjects(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath="//input[@name='apiKey']")
    private static WebElement apiKey;

    @FindBy(xpath="//input[@name='apiSecret']")
    private static WebElement secretKey;

    @FindBy(name ="submitted")
    private static  WebElement submit;

    @FindBy(xpath = "//input[@name='amount']")
    private static WebElement amount;

    @FindBy(xpath = "//button[@type='button']")
    private static WebElement checkOut;

    @FindBy(xpath = "//div[@class='mode'][1]")
    private static WebElement crediCard;

    @FindBy(xpath = "//div[@class='mode' and contains(text(),'Net')]")
    private static WebElement netBanking;


    @FindBy(xpath = "//input[@type='text'][1]")
    private static WebElement creditCardNumber;

    @FindBy(xpath = "//input[@type='number'][1]")
    private static WebElement creditDate;

    @FindBy(xpath = "//input[@type='number'][2]")
    private static  WebElement creditYear;

    @FindBy(xpath = "//div[@class='pure-u-1']//button")
    private static WebElement payButton;

    @FindBy(xpath = "//input[@type='password']")
    private static WebElement cvvNumber;

    @FindBy(xpath = "//select[@id='selectAuthResult']")
    private static WebElement selectOption;

    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement submit2;

    @FindBy(xpath = "//input[@type='radio']")
    private static WebElement netBankingRadioButton;

    @FindBy(xpath = "//button[@type='button']")
    private static WebElement payNowButton;

    @FindBy(id="name")
    private static WebElement usrname;

    @FindBy(id="password")
    private static WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement submitButtonNetBanking;

    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement submit3;

    @FindBy(xpath="//input[@id='username']")
    private  static WebElement usernameNetBanking;

    @FindBy(xpath="//input[@id='password']")
    private  static WebElement passwordNetBanking;

    @FindBy(xpath = "//input[@type='submit']")
    private static  WebElement submitNetBanking;

    @FindBy(xpath="//input[@value='Simulate Success Response']")
    private static  WebElement simulateSuccess;

    @FindBy(xpath="//input[@value='Simulate Failure Response']']")
    private static  WebElement simulateFailure;



    @FindBy(xpath="//input[@type=\"button\"]")
    private static  WebElement continueButton;

    @FindBy(xpath="//input[@id='basic-otp']")
    private static  WebElement otp;

    @FindBy(xpath="//div[@data-status=\"SUCCESS\"]")
    private static  WebElement success;

    //div[@id="successForm"]

    @FindBy(xpath="//div[@id=\"successForm\"]")
    private static  WebElement submitSuccess;

    public static WebElement getApiKey()
    {
        return apiKey;
    }

    public  static  WebElement getSecretKey()
    {
        return  secretKey;
    }

    public static WebElement getSubmit()
    {

        return submit;
    }

    public static WebElement setAmount()
    {
        return amount;
    }

    public static  WebElement clickCheckOut()
    {
        return  checkOut;
    }

    public static WebElement getCrediCard()
    {
        return  crediCard;
    }

    public static WebElement getNetBanking()
    {
        return  netBanking;
    }

    public static WebElement getCreditCardNumber()
    {
        return  creditCardNumber;
    }

    public static WebElement getCreditDate()
    {
        return creditDate;
    }

    public static WebElement getCreditYear()
    {
        return  creditYear;
    }

    public static WebElement getPayButton()
    {
        return  payButton;
    }

    public static WebElement getCvvNumber()
    {
        return cvvNumber;
    }

    public static WebElement getSelectOption()
    {
        return  selectOption;
    }

    public static WebElement getSubmit2()
    {
        return submit2;
    }

    public static WebElement getNetBankingRadioButton()
    {
        return netBankingRadioButton;
    }

    public static WebElement getPayNowButton()
    {
        return payNowButton;
    }

    public static WebElement getSubmitButtonNetBanking()
    {
        return submitButtonNetBanking;
    }


    public static WebElement getSubmit3()
    {
        return submit3;
    }

    public static  WebElement getUsernameNetBanking()
    {
        return usernameNetBanking;
    }

    public static WebElement getPasswordNetBanking()
    {
        return  passwordNetBanking;
    }

    public  static WebElement getSubmitNetBanking()
    {
        return  submitNetBanking;
    }

    public static WebElement  getSimulateSuccess()
    {
        return  simulateSuccess;
    }

    public static WebElement  getSimulateFailure()
    {
        return  simulateFailure;
    }


    public static WebElement  getContinue()
    {
        return  continueButton;
    }

    public static WebElement  getOTP()
    {
        return  otp;
    }
    public static WebElement  getSuccess()
    {
        return  success;
    }
    public static WebElement  getSubmitSuccess()
    {
        return  submitSuccess;
    }

}
