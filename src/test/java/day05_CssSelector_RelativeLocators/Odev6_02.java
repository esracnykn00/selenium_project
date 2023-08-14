package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class Odev6_02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*

         2- https://www.google.com/
        adresine gidin
        3- cookies uyarisini
        kabul ederek kapatin
        4. Sayfa basliginin “Google” ifadesi icerdigini test
                edin
        5. Arama cubuguna “Nutella” yazip aratin
        6. Bulunan sonuc sayisini yazdirin
        7. sonuc sayisinin 10 milyon’dan fazla oldugunu test
        edin
        8. Sayfayi kapatin

         */

        driver.get("https://www.google.com/");

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        if (actualTitle.contains("Google")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        Thread.sleep(2000);

        WebElement sonucSayisi = driver.findElement(By.cssSelector("div[id='result-stats']"));
        System.out.println(sonucSayisi.getText());
        //Sadece sonuc sayısını yazdırınız
        String [] sadeceSonuc = sonucSayisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sadeceSonuc[1]);
        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin








    }
}
