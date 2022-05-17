package Ders_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class driverTanimlama {

    static WebDriverManager driver;

    @Test
    public void driver_Tanimlama(){
        //Driver'imizi kullanabilir hale getirdik
        WebDriver driver;

        //Driver'imizi chromedriver'a tanitiyoruz
        WebDriverManager.chromedriver().setup();

        //driver nesnesi olusturuyoruz
        driver=new ChromeDriver();

        //sayfamizi tam ekran yapiyoruz
        driver.manage().window().maximize();
        //sayfamizin yuklenmesi icin driver'imizi bekletiyoruz
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        //ilk deneme
        driver.get("https://google.com");

    }

}