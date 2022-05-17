package Ders_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class googleArama {

    static WebDriver driver;

    @Test
    public void partialLinkText() throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");

        WebElement guvenlikDuvari=driver.findElement(By.xpath("//*[.='I agree']"));
        Thread.sleep(1000);
        guvenlikDuvari.click();

        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("city bike"+ Keys.ENTER);
        // arama.submit();

        WebElement sonuc = driver.findElement(By.id("result-stats"));
        System.out.println("City Bike ==>"+ sonuc.getText());

        WebElement shopping = driver.findElement(By.partialLinkText("Shopping"));
        shopping.click();



    }
}
