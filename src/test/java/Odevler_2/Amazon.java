package Odevler_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Amazon {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://amazon.com");
    }

    @BeforeMethod
    public static void bM(){


    }

    @Test
    public static void amazonTest1() throws InterruptedException {

        WebElement kategori = driver.findElement(By.id("searchDropdownBox"));
        Thread.sleep(3000);
        Select select = new Select(kategori);
        Thread.sleep(3000);
        select.selectByVisibleText("Computers");

        WebElement box = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);
        box.click();
        Thread.sleep(3000);
        box.sendKeys("Computer mice"+ Keys.ENTER);

        WebElement veri = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Thread.sleep(3000);
        String sonuc = veri.getText();
        System.out.println("Arama Sonucu ==> " + sonuc);

        WebElement resim = driver.findElement(By.className("s-image"));
        Thread.sleep(3000);
        boolean gorunuyormu = resim.isDisplayed();
        Thread.sleep(3000);
        Assert.assertTrue(gorunuyormu);

    }

    @Test
    public static void amazonTest2() throws InterruptedException {

        WebElement kategori2 = driver.findElement(By.id("searchDropdownBox"));
        Thread.sleep(3000);
        Select select2 = new Select(kategori2);
        Thread.sleep(3000);
        select2.selectByIndex(13);

        WebElement box2 = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);
        box2.clear();
        Thread.sleep(3000);
        box2.sendKeys("tea glass"+Keys.ENTER);

        WebElement veri2 = driver.findElement(By.className("a-price"));
        Thread.sleep(3000);
        System.out.println("<tea glass> Fiyati ==> " + veri2.getText());

    }

    @AfterMethod
    public static void aC(){}

    @AfterClass
    public static void tearDown(){}
}