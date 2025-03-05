package BaseClass;

import configFileReader.configFileRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


public class BaseClass  extends configFileRead {
    public static WebDriver driver;

    @BeforeSuite
    public void start() throws InterruptedException {
        String browser = configFileRead.getBrowser();
        System.out.println(browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
             driver = new ChromeDriver(options);
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-debugging-port=9222");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");


            driver.get(configFileRead.getURL());

          /*  driver.navigate().to("https://sk-admin.babujiventures.in/login");
            Thread.sleep(5000);
            driver.navigate().refresh();*/
            driver.manage().window().maximize();



            System.out.println("URL opened");


        }
    }







   @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}