package Ders_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class xpath {

    WebDriver driver;

    @Test
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://gcreddy.com/project/admin/login.php");

        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("gcreddy");
        WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
        pass.sendKeys("Temp@2020");

        WebElement login = driver.findElement(By.xpath("//button[@id='tdb1']"));
        login.click();
      /*
        //tagName[@attirbute='value']     ==> butun araclari yaziyoruz.
        (//input[@type='text'])[2]         ==> Ayni ozelliklere sahip arac(tagName,Attirbute,text..)
        //input[@type='password' or @name='password']    =>bir tanesinin dogru olmasi yetiyor.
         //input[@type='password' and @name='password']
         //*[@type='text']      =>      tagName'i ne olursa olsun,attribute(type) ve value(text)'e gore buluyoruz
        (//*[.='Login'])[3]     =>       icerdigi yazi Login olan tum webElementlere ulasmak icin kullaniyoruz
        (//span[.='Login'])[2]   =>      icedigi yazi Login olan ve tagNem'i span oln tum WebElementleri bulmamizi saglar
        //*[contains(text(),'Catalog')]   => icerisinde  "Catalog" gecen tum elementleri bulmamizi saglar
 */
    }
}
