package Odevler_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AmazonFacebook {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.out.println("BeforeClass Basladi...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public static void bM(){

        System.out.println("BeforeMethod Basladi...");
    }

    @Test
    public static void amazon(){

        System.out.println("Test Basladi...");

        driver.get("https://amazon.com");
        WebElement sorgu1 = driver.findElement(By.id("twotabsearchtextbox"));
        sorgu1.sendKeys("computer"+ Keys.ENTER);

        driver.navigate().to("https://facebook.com");
        driver.navigate().refresh();
        driver.navigate().back();
        WebElement temizle = driver.findElement(By.id("twotabsearchtextbox"));
        temizle.click();
        temizle.clear();
        temizle.sendKeys("s22"+Keys.ENTER);

        WebElement veri = driver.findElement(By.className("sg-col-inner"));
        String sonuc = veri.getText();
        System.out.println("s22 Arama Sonucu ==> "+sonuc);
        driver.quit();
    }

    @AfterMethod
    public static void aM(){

        System.out.println("AfterMethod Basladi...");
    }

    @AfterClass
    public static void tearDown(){

        System.out.println("AfterClass Basladi...");
    }
}
