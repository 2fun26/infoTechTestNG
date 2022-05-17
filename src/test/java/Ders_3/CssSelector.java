package Ders_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CssSelector {

    WebDriver driver;

    @Test
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://facebook.com");
        WebElement guvenlikDuvari=driver.findElement(By.xpath("//*[.='Allow essential and optional cookies']"));
        Thread.sleep(1000);
        guvenlikDuvari.click();


        WebElement email=driver.findElement(By.cssSelector("input#email"));
        email.sendKeys("emre@gmail.com");

        WebElement sifre= driver.findElement(By.cssSelector("input[type='password']"));
        sifre.sendKeys("3427sjsjdskl"+ Keys.ENTER);

/*
  1-  "tagName[attribute name='value']"

  2-  "tagName#id value"  yada "id value"  => sadece id value'si icin gecerlidir

  3-  "tagName.class value"  yada ".class value"  => yanlizca class value ile calisir.


 */

    }
}