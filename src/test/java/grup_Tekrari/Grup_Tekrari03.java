package grup_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.security.auth.login.AccountLockedException;
import java.util.IllegalFormatCodePointException;

public class Grup_Tekrari03 {
    public static void main(String[] args) throws InterruptedException {

        // "https://teknosa.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        // "https://medunna.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        // teknosa adresine geri donunuz
        // Sayfayı yenileyiniz
        // medunna adresine ilerleyiniz
        // Sayfayı yenileyiniz
        // pencereyi kapat

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://teknosa.com/");
        Thread.sleep(2000);
        String teknosaTitle = driver.getTitle();
        System.out.println("teknosaTitle = " + teknosaTitle);
        String teknosaUrl = driver.getCurrentUrl();
        System.out.println("teknosaUrl = " + teknosaUrl);

        if (driver.getTitle().contains("Teknoloji")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        if (driver.getCurrentUrl().contains("teknosa")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.get("https://medunna.com/");
        String medunnaTitle = driver.getTitle();
        System.out.println("medunnaTitle = " + medunnaTitle);
        String medunnaUrl = driver.getCurrentUrl();
        System.out.println("medunnaUrl = " + medunnaUrl);

        if (driver.getTitle().contains("MEDUNNA")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        if (driver.getCurrentUrl().contains("medunna")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.close();






    }
}
