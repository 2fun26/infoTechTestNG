package Ders_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigationKomutlar {

    static WebDriverManager driver;

    @Test
    public void driver_Tanimlama() throws InterruptedException {

        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1- get()  herhangi bir syafaya gitmek icin kullaniyoruz.
        driver.get("https://google.com");

        Thread.sleep(2000);

        //2- navigate().to()   ==> bulundugumuz sayfadan baska bir sayfaya gitmemizi saglar.
        driver.navigate().to("https://amazon.com");

        Thread.sleep(2000);

        //3-navigate().back   ==>geldigimiz sayfaya geri donmemizi saglar
        driver.navigate().back();

        Thread.sleep(2000);

        //4-navigate().forward();
        driver.navigate().forward();

        Thread.sleep(2000);

        //5-calistigimiz sayfayi buyutmeye yariyor
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //6-navigate().refresh()  calistigimiz sayfayi guncellemeye(yineleme) yapar.
        driver.navigate().refresh();

        //7-close() calistigimiz sayfayi kapatmaya yariyor
        //    driver.close();

        Thread.sleep(3000);

        //8-quit()  calistigimiz tum sayfayi kapatir
        driver.quit();


    }
}