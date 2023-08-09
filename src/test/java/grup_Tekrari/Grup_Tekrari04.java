package grup_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Grup_Tekrari04 {
    public static void main(String[] args) {

        // https://www.amazon.com/ adresine gidin
        // Kaynak Kodlarini konsola yazdiriniz
        // Kaynak Kodlarinda "window" yazdigini test edin
        // sayfayi kapatiniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        String sayfaKaynakKodlari = driver.getPageSource();
        System.out.println("sayfaKaynakKodlari = " + sayfaKaynakKodlari);

        if (sayfaKaynakKodlari.contains("window")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }























    }
}
