package Ders_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class dropDown {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDown);

        select.selectByVisibleText("Baby");

        Thread.sleep(5000);
        select.selectByIndex(5);
        Thread.sleep(5000);
        select.selectByValue("search-alias=computers-intl-ship");

        WebElement secim = select.getFirstSelectedOption();
        System.out.println("Son secili kategori ==> "+secim.getText());

        List<WebElement> liste = select.getOptions();

        for(WebElement each : liste){
            System.out.println(each.getText());
        }

        int toplamSecenekSayisi = liste.size();
        System.out.println("Tolam Kategori Sayisi ==> "+toplamSecenekSayisi);
    }
}
