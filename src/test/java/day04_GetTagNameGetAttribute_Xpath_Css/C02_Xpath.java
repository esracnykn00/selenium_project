package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        /*
        Bir webelementi locate etmek istedigimizde o elementin unique olmasi gerekir. Xpath kullanimini
        biliyorsak istedigimiz webelementi her zaman unique alabiliriz.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a.web sayfasına gidin. https://www.amazon.com/
        //b. Search(ara) “city bike”
        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        //Sadece sonuc sayisini yazdirin
        //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın

        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);
        driver.navigate().refresh();
        driver.navigate().refresh();
        //simdi arama kutusunu xpathle locate ediyorum
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);
        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(aramaSonucu.getText());
        //Sadece sonuc sayısını yazdırınız
        String [] sonucSayisi = aramaSonucu.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sonucSayisi[2]);

        //Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//h2//a)[1]")).click();
        //xpath alırken direk tag'ları kullanarakta unique sonuç vermezse yukarıdaki örnekteki gibi index ile elementi handle edebiliriz

        //sayfayi kapatınız
        driver.close();



        //NOT: Xpath kullaniminda //sembolleri ile baslariz. Bu sembollerden sonra tag name belirtmeniz gerekir.
        //tag name yerine * sembolunu kullanabilirsiniz. Bu sembol tag name farketmeksziin anlamina gelir.
        //Sonra koseli parantez acip kullanacagimiz attributeten once @ sembolu kullanmaliyiz. sonrasinda da
        //attribute yazilip TEK TIRNAK icinde attribute un degeri yazilmalidir ve koseli parantez kapatilir.
       /*
         SYNTAX:
                    //tagName[@attributeName='attributeDegeri']
                    //*[@*='attributeDegeri'] --> Eger bu kullanimda birden fazla sonuc verirse * koydugumuz yerlere
                                                  tagName ve attributeName i belirtmemiz gerekir. Buna ragmen birden
                                                  fazla sonuc verirse o webelementin indexini asagidaki sekilde belirtiriz.
                                                  (//tagName[@attributeName='attributeDegeri'][index]

                 Xpath kullanamadığız zaman bir webelementin locate'i ile alakalı birden fazla sonuç çıkarsa bütün sonuçları
              bir list'e atıp index ile o webelemnti handle etmen gerekecekti. Dolayısıyla yukarıdaki örnekteki gibi
              xpath kullanımında birden fazla sonuç alırsak direk xpath üzerinden index ile bunu çözebiliriz.
        */



























    }
}
