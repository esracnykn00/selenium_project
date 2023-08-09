package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ManageMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*
        Driver i olusturduktan sonra maximize yapmamiz bizim icin gitmek istedigimiz sayfadaki webelementlere(sayfadaki elementlere)
         daha rahat sorunsuz ulasmak icin onemlidir.
         Bunun icin driver i heemn olusturduktan sonra manage().maximize() methodunu kullaniriz.
         Maximize yaptiktan snra internetten kaynakli sayfa performansindan kaynakli sayfadaki elemtler hemen yuklenemeyebilir.
         Dolayisiyla sayfaya gittikten sonra bir elemente, bir butona tiklamak istedigimizde hemen sayfa yuklenmez ise
         elementi bulamayacagi icin tiklama islemini gerceklestiremeyecegi icin testimiz fail verecek.
         Bunun onune gecmek icin [her defasinda thread.sleep() ile ugrasmamak icin yani] maximize methodundan sonra driver imiza
         seleniumdan gelen implicitly wait atamasi yapariz. Bu wait ile sayfanin tum elementlerinin olusmasini beklemesi icin
         max bir sure belirtiriz.
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //drive yonet zamani ve bekleme sureisni Duration.ofSeconds(15)ile belirtmis olduk

        //techpro sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //sayfa basliginin techpro icerdigini test edin
        if (driver.getTitle().contains("TechPro")) {
            System.out.println("PASSED");
        } else
            System.out.println("FAILED");


        //Sayfayi kapatiniz
        driver.close();


    }

}