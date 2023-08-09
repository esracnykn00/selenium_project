package grup_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Grup_Tekrari02 {
    public static void main(String[] args) throws InterruptedException {

        // "https://www.amazon.com/" adresine gidiniz.
        // "https://www.n11.com/" adresine gidiniz.
        // amazon adresine geri donunuz
        // n11 adresine ilerleyiniz
        // sayfayi yenileyiniz
        // pencereyi kapat
        // Konsola "HER ŞEY YOLUNDA" yazdir

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        driver.get("https://www.n11.com/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(1500);
        driver.navigate().forward();
        Thread.sleep(1500);
        driver.navigate().refresh();

        driver.close();










    }
}
