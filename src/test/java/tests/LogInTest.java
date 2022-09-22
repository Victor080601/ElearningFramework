package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LogInTest extends ShareData {

    ElementMethods element = new ElementMethods(driver);

    @Test
    public void checkInMethod() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        By clickCookie = By.xpath("//div[@class='cookie-consent-footer-content']//button[contains(@class,'cookie-consent')]");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clickCookie));
        WebElement clickOk = driver.findElement(clickCookie);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickOk);

        String actualText = driver.getTitle();
        String expectedText = "UniTBv";
        Assert.assertEquals(expectedText, actualText);

        Thread.sleep(5);
        By locatorPlatform = By.cssSelector("ul>li[id='iceMenu_773']");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locatorPlatform));
        WebElement hoverOverPlatforme = driver.findElement(locatorPlatform);
        Actions builder = new Actions(driver);
        Thread.sleep(1000);
        builder.moveToElement(hoverOverPlatforme).perform();
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(hoverOverPlatforme).moveToElement(driver.findElement(By.cssSelector("li>a[href='https://elearning.unitbv.ro/']"))).click().perform();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        WebElement fieldEmailElement = driver.findElement(By.id("username"));
        String emailValue = "victor.oprea@student.unitbv.ro";
        element.fillElement(fieldEmailElement,emailValue);

        WebElement fieldPasswordElement = driver.findElement(By.cssSelector("input[type='password']"));
        String passwordValue = "Testautomation123";
        element.fillElement(fieldPasswordElement, passwordValue);

        WebElement connectElement = driver.findElement(By.xpath("//button[text()='Conectare']"));
        element.clickElement(connectElement);

        WebElement verifyName = driver.findElement(By.xpath("//span[@class='usertext mr-1']"));
        String actualResults1 = verifyName.getText();
        String expectedResults1 = "Oprea Victor Vasile";
        Assert.assertEquals(actualResults1,expectedResults1);

        WebElement dropdownButtonforCourse  = driver.findElement(By.xpath("//div[@data-course-id='2804']/div/div/div[2]/button"));
        element.clickElement(dropdownButtonforCourse);

        WebElement selectFavourite = driver.findElement(By.xpath("//div[@x-placement='bottom-end']/a[1]"));
        element.clickElement(selectFavourite);

//        WebElement quitFavourite = driver.findElement(By.xpath("//div[@x-placement='bottom-end']/a[2]"));
//        element.clickElement(quitFavourite);
        Thread.sleep(1000);
        By searchLocator = By.id("groupingdropdown");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(searchLocator));
        WebElement searchBar = driver.findElement(searchLocator);
        element.clickElement(searchBar);

        List<WebElement> languageOptions = driver.findElements(By.xpath(" //div[@id='yui_3_17_2_1_1663669950143_37']/ul/li[8]/a"));
        for(int i=0;i<languageOptions.size();i++)
        {
            if(languageOptions.get(i).getText().equals("Favorit"))
            {
                languageOptions.get(i).click();
            }
        }


//        WebElement searchBar1 = driver.findElement(By.xpath("//button[@id='groupingdropdown']"));
//        element.clickElement(searchBar1);
//
//
        WebElement clickOnCourse = driver.findElement(By.xpath("//span[text()='Sisteme de operare_IAG']"));
        element.clickElement(clickOnCourse);

        WebElement clickOnFirstCourse = driver.findElement(By.xpath("//span[text()='Cursul 1']"));
        element.clickElement(clickOnFirstCourse);

        WebElement clickOnPdf = driver.findElement(By.xpath("//span[text()='Curs1.pdf']"));
        element.clickElement(clickOnPdf);


    }


}
