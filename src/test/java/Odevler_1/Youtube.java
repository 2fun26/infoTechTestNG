package Odevler_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Youtube {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.out.println("BeforeClass Basladi...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public static void bM(){

        System.out.println("BeforeMethod Basladi... ");
    }

    @Test
    public static void youTube1() throws InterruptedException {

        System.out.println("Test1 Basladi...");

        driver.navigate().to("https://youtube.com");
        WebElement guvenlik = driver.findElement(By.xpath("//yt-formatted-string[.='Accept all']"));
        guvenlik.click();
        Thread.sleep(3000);

        WebElement arama = driver.findElement(By.cssSelector("input[id='search']"));
        Thread.sleep(3000);
        arama.click();
        arama.sendKeys("lavitated"+Keys.ENTER);
        Thread.sleep(3000);


        WebElement music1 = driver.findElement(By.xpath("//a[@id='video-title']"));
        Thread.sleep(3000);
        music1.click();
        Thread.sleep(2350);

         WebElement veri1 = driver.findElement(By.id("info-text"));
         Thread.sleep(3000);
         String sonuc = veri1.getText();
         System.out.println("1nci Muzik Arama Sonucu ==> "+sonuc);
    }

    @Test
    public static void youTube2() throws InterruptedException {

        driver.navigate().back();
        WebElement arama = driver.findElement(By.cssSelector("input[id='search']"));
        Thread.sleep(3000);
        arama.click();
        arama.clear();
        Thread.sleep(1000);
        arama.sendKeys("Death Pool official hd trailer"+Keys.ENTER);

        WebElement film = driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));
        Thread.sleep(2000);
        film.click();
        Thread.sleep(15000);
    }

    @Test
    public static void youTube3() throws InterruptedException {

        driver.navigate().back();
        WebElement arama = driver.findElement(By.cssSelector("input[id='search']"));
        Thread.sleep(3000);
        arama.click();
        arama.clear();
        Thread.sleep(1000);
        arama.sendKeys("how does the panama canal work?"+Keys.ENTER);

        WebElement belgesel = driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));
        Thread.sleep(2000);
        belgesel.click();

        WebElement veri = driver.findElement(By.xpath("//div[@id='info-text']"));
        String sonuc = veri.getText();
        System.out.println("Belgesel ==> "+sonuc);

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
