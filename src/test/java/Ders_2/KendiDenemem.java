package Ders_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KendiDenemem {

    static WebDriver driver;

    @Test
    public void Pratik1(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement guvenlik = driver.findElement(By.xpath("//*[.='I agree']"));
        guvenlik.click();

        driver.findElement(By.id("gbqfbb")).click();



    }
}
