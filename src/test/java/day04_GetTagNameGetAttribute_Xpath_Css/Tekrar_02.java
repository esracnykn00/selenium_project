package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tekrar_02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a.web sayfasına gidin. https://www.amazon.com/
        //b. Search(ara) “city bike”
        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        //Sadece sonuc sayisina tiklayiniz
        //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın


        driver.get("https://amazon.com");
        Thread.sleep(5000);
        driver.navigate().refresh();
        driver.navigate().refresh();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama Sonucu : "+aramaSonucu.getText());

        String [] sonucSayisi = aramaSonucu.getText().split(" ");
        System.out.println("Sonuc Sayisi : "+sonucSayisi[2]);

        driver.findElement(By.xpath("(//h2//a)[1]")).click();
        //Dinamik olarak direkt taglari kullanarak da unique sonuc vermezse yukaridaki ornekteki gibi
        // index ile elementi handle edebiliriz
        driver.close();


    }
}
