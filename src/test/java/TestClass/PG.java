package TestClass;

import BaseClass.BaseClass;
import PageObjectsClass.aggregatorPanelObjects;
import actionclass.actionClass;
import configFileReader.configFileRead;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class PG extends BaseClass {



        actionClass act= new actionClass();
        @Test(invocationCount = 1,description = "CreditPayment")
        public void payment1() throws InterruptedException {

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
            PageFactory.initElements(driver, aggregatorPanelObjects.class);
            act.clear(aggregatorPanelObjects.getApiKey());
            act.sendKeys(aggregatorPanelObjects.getApiKey(),"9099a132-1017-4b8d-aeb7-5388c3e76bf2");
            act.clear(aggregatorPanelObjects.getSecretKey());
            act.sendKeys(aggregatorPanelObjects.getSecretKey(),"1mHv2gPMrB5EZ2klyp5I4l9j/d2O2W4BBhdNWzXsi2g=");
            act.clear(aggregatorPanelObjects.setAmount());
            act.sendKeys(aggregatorPanelObjects.setAmount(),"500");
            act.click(aggregatorPanelObjects.getSubmit());
            // act.click(aggregatorPanelObjects.clickCheckOut());

            //credit card payment
            act.click(aggregatorPanelObjects.getCrediCard());
            act.sendKeys(aggregatorPanelObjects.getCreditCardNumber(),"4111111111111111");
            act.sendKeys(aggregatorPanelObjects.getCreditDate(),"12");
            act.sendKeys(aggregatorPanelObjects.getCreditYear(),"25");
            act.sendKeys(aggregatorPanelObjects.getCvvNumber(),"123");
            act.click(aggregatorPanelObjects.getPayButton());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(2000);
            act.click(aggregatorPanelObjects.getSelectOption());
            act.selectByIndex(aggregatorPanelObjects.getSelectOption(),0);
            act.click(aggregatorPanelObjects.getSubmit3());


            Thread.sleep(5000);




            //netBanking Payment
        /*
        act.click(aggregatorPanelObjects.getNetBanking());
         */


        }





        @Test(invocationCount = 1,description = "netBanking")
        public void payment2() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
            PageFactory.initElements(driver, aggregatorPanelObjects.class);
            act.clear(aggregatorPanelObjects.getApiKey());
            act.sendKeys(aggregatorPanelObjects.getApiKey(),"9099a132-1017-4b8d-aeb7-5388c3e76bf2");
            act.clear(aggregatorPanelObjects.getSecretKey());
            act.sendKeys(aggregatorPanelObjects.getSecretKey(),"1mHv2gPMrB5EZ2klyp5I4l9j/d2O2W4BBhdNWzXsi2g=");
            act.clear(aggregatorPanelObjects.setAmount());
            act.sendKeys(aggregatorPanelObjects.setAmount(),"5000");
            act.click(aggregatorPanelObjects.getSubmit());
            act.click(aggregatorPanelObjects.clickCheckOut());

            //netBanking Payment
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            act.click(aggregatorPanelObjects.getNetBanking());
            act.click(aggregatorPanelObjects.getNetBankingRadioButton());
            act.click(aggregatorPanelObjects.getPayNowButton());
            act.click(aggregatorPanelObjects.getContinue());
            act.sendKeys(aggregatorPanelObjects.getOTP(),"111000");
            act.click(aggregatorPanelObjects.getSuccess());
          //  act.click(aggregatorPanelObjects.getSubmitButtonNetBanking());
            Thread.sleep(1000);

          //commented for the changes done in the PG
           /* act.sendKeys(aggregatorPanelObjects.getUsernameNetBanking(), "payu");
            act.sendKeys(aggregatorPanelObjects.getPasswordNetBanking(),"payu");
            act.click(aggregatorPanelObjects.getSubmitButtonNetBanking());
            Thread.sleep(1000);

            act.click(aggregatorPanelObjects.getSimulateSuccess());
           // act.click(aggregatorPanelObjects.getSubmit2());    */
            driver.get(configFileRead.getURL());




        }


    }



