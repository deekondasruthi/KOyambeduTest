package PageObjectsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class offlinePageObjects {
    WebDriver driver;
    public offlinePageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath="//input[@name='subMerchantId']")
    private static WebElement subMID;

    @FindBy(xpath="//input[@name='merchantTranId']")
    private static WebElement MtID;

    @FindBy(xpath="//input[@name='PayerAmount']")
    private static WebElement payerAmount;


    @FindBy(xpath="//button[@name='submitted']")
    private static WebElement submit;
    public static WebElement getSubMID()
    {
        return subMID;
    }

    public static WebElement getMtID()
    {
        return MtID;
    }
    public static WebElement getPayerAmount()
    {
        return payerAmount;
    }

    public static WebElement getSubmit()
    {
        return submit;
    }

}
