package TestClass;

import BaseClass.BaseClass;
import PageObjectsClass.offlinePageObjects;
import actionclass.actionClass;
import configFileReader.configFileRead;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class offlinePayment extends BaseClass {
    actionClass act =new actionClass();


    @Test(invocationCount =10)
    public void off() throws InterruptedException, AWTException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        PageFactory.initElements(driver, offlinePageObjects.class);

        act.clear(offlinePageObjects.getSubMID());
        act.sendKeys(offlinePageObjects.getSubMID(),"563655");
        //Thread.sleep(2000);
        act.clear(offlinePageObjects.getMtID());
        act.sendKeys(offlinePageObjects.getMtID(),"ATCSQR3121");
        //Thread.sleep(2000);
        act.clear(offlinePageObjects.getPayerAmount());
        act.sendKeys(offlinePageObjects.getPayerAmount(),"200.00");
        act.click(offlinePageObjects.getSubmit());
        driver.get(configFileRead.getURL());

    }
}
