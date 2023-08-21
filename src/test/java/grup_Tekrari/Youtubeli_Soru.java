package grup_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Youtubeli_Soru {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



         //Youtube web sayfasına gidin ve sayfa başlığının "youtube" olup olmadığını doğrulayın
        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com/");
        String actualTitle = driver.getTitle();
        System.out.println("Sayfa Basligi : "+ actualTitle);
        if (actualTitle.contains("youtube")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //Sayfa URL'sinin "youtube" içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        //URL'yi yazdırın.
        String actuelUrl = driver.getCurrentUrl();
        System.out.println("Sayfa Url'i = " + actuelUrl);
        if (actuelUrl.contains("youtube")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Youtube sayfasina geri donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //Amazon sayfasina donun
        driver.navigate().forward();

        //Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
        //başlığı(Actual Title) yazdırın.
        String actualTitle2 = driver.getTitle();
        if (actualTitle.contains("Amazon")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println(actualTitle2);
        }



        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        String actualUrl2 = driver.getCurrentUrl();
        if (actualUrl2.contains("https://www.amazon.com/")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //11.Sayfayi kapatin
        driver.close();





















    }
}
