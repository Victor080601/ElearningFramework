package shareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ShareData {

    public WebDriver driver;

    @BeforeMethod
    public void prepareDriver(){
        //setez driverul de chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //deschid un browser de chrome
        driver = new ChromeDriver();
        //accesez un anumit URL
        driver.get("https://www.unitbv.ro/");

        //facem browser-ul maximaze
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitDriver(){
//        driver.quit();
    }



}