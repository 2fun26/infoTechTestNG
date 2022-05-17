package Ders_4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class isDisplayed {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void titleTest(){
        String title=driver.getTitle();
        System.out.println(title);
        boolean gorunuyormu=title.contains("Best");
        Assert.assertTrue(gorunuyormu);
    }
    @Test
    public void logo(){
        WebElement logo=driver.findElement(By.className("logo"));
        boolean gorunuyormu=logo.isDisplayed();
        Assert.assertTrue(gorunuyormu);
    }
    @Test
    public void link(){
        WebElement link=driver.findElement(By.linkText("Mexico"));
        //  WebElement linkMexico= driver.findElement(By.partialLinkText("Mex"));
        boolean gorunuyormu=link.isDisplayed();
        Assert.assertTrue(gorunuyormu);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
