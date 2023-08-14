package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidiniz
        //Arama kutusunu locate ediniz ve iphone yazdırıp aratınız
        //Sayfayı kapatınız

        driver.get("http://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.sendKeys("iphone");
        WebElement aramaKutusu = driver.findElement(By.name("field-keywords"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //aramaKutusu.submit(); //Enter tusuna basariz
        //NOT: submit() kullanmadan direkt iphone yi yazdiktan sonra Keys.ENTER yazmam da yeterli


        /*
             Sayfadaki bir webelemnti locate etmek icin oncelikle locate edecegimin webelementin
             uzerine sag tiklayip sayfanin altinda acilan webelementle alakali html kodlarina ulasabilir.
             Bu html kodlari yardimiyla eger webelemntin html kodlarinda id attribute'une sahip bir deger varsa locate
             icin once bunu kullanabiliriz. Attribute degerine cift tiklayip ctrl+c --> ctrl+f --> ctrl+v
             yaparak ogenin unique(tek) olup olmadigini html kodlarin alt kismindaki arama bolumunden kontrol ederiz.
             Ve tek olan attribute degerini o webelementin handle edebilmek icin cok rahata yukaridaki ornekteki gibi
             kullanabiliriz.

             Input tagina sahip bir Web Elementi locate ettikten sonra sendKeys() methodu ile
             o  web elemente istedigimiz text i gonderebiliriz.

              Bir text'i arama kutusuna gonderdikten sonra klavyeden nasil enter tusuna basiyorsak otomasyon ile de
              bunu yaptirabiliriz.Bunun icn iki yol vardir:
                                  1) submit() methodunu kullanarak enter yaptirabiliriz.
                                  2) Tanimlanmis veri tipi olan(enum) Keys.ENTER i kullanabiliriz.
         */
















    }
}
