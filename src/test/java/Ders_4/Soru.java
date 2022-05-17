package Ders_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Soru {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public static void bC(){

        driver.get("https://bestbuy.com");
    }

    @Test
    public static void TitleTest(){



        String title = driver.getTitle();
        System.out.println(title);
        boolean gorunuyormu = title.contains("Best");
        Assert.assertTrue(gorunuyormu);
        driver.quit();
    }

    @Test
    public static void LogoTest(){

        WebElement logo= driver.findElement(By.className("logo"));
        boolean gorunuyormu= logo.isDisplayed();
        Assert.assertTrue(gorunuyormu);
        driver.quit();
    }

    @Test
    public static void MexicoLinkTest(){

        WebElement link = driver.findElement(By.linkText("Mexico"));
//        WebElement link1 = driver.findElement(By.partialLinkText("Mex"));
        boolean gorunuyormu = link.isDisplayed();
        Assert.assertTrue(gorunuyormu);
    }

}