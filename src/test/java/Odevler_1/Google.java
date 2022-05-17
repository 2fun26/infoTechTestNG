package Odevler_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Google {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.out.println("Before Class Basladi...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");
        WebElement guvenlik = driver.findElement(By.xpath("//*[.='I agree']"));
        guvenlik.click();

        String title = driver.getTitle();
        System.out.println("Title==> "+title);
        String url = driver.getCurrentUrl();
        System.out.println("CurrentUrl==> "+url);

        if(title.contains("Google")){

            System.out.println("Title DOGRU.");
        }
        else{

            System.out.println("Title YALNIS!");
        }

        if(url.contains("https://www.google.com/")){

            System.out.println("Current Url DOGRU.");
        }
        else{

            System.out.println("Current Url YALNIS!");
        }
    }

    @BeforeMethod
    public static void bC(){

        System.out.println("Before Method Basladi...");

    }

    @Test
    public static void test1(){

        System.out.println("Test1 Baladi...");

        WebElement arama1 = driver.findElement(By.name("q"));
        arama1.sendKeys("Kulaklik"+ Keys.ENTER);
        WebElement veri1 = driver.findElement(By.id("result-stats"));
        String sonuc1 = veri1.getText();
        System.out.println("Kulaklik Arama Sonucu ==> "+sonuc1);
    }

    @Test
    public static void test2(){

        System.out.println("Test2 Basladi...");

        driver.get("https://google.com");
        WebElement arama2 = driver.findElement(By.name("q"));
        arama2.sendKeys("masa"+Keys.ENTER);
        WebElement veri2 = driver.findElement(By.id("result-stats"));
        String sonuc2 = veri2.getText();
        System.out.println("masa Arama Sonucu ==> "+sonuc2);
    }

    @Test
    public static void test3(){

        System.out.println("Test3 Basladi...");

        driver.get("https://google.com");
        WebElement arama3 = driver.findElement(By.name("q"));
        arama3.sendKeys("sandalye"+Keys.ENTER);
        WebElement veri3 = driver.findElement(By.id("result-stats"));
        String sonuc3 = veri3.getText();
        System.out.println("sandalye Arama Sonucu ==> "+sonuc3);

    }

    @AfterMethod
    public static void aM(){

        System.out.println("After Method Basladi...");
    }

    @AfterClass
    public static void tearDown(){

        System.out.println("After Class Basladi...");
        driver.quit();
    }

}
