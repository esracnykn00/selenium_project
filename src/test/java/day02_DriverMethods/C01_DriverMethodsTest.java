package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //bu bize bos bir browser acti.

        //not:tekrar tekrar yazmamak yerine bunlari bir kere yazip atama yapabiliriz ustte bu sebepten
        //asagidaki iki Stringi;
        String amazonUrl = "http://amazon.com";
        String techprourl = "http://techproeducation.com";

        //Amazon sayfasina gidiniz
        driver.get("http://amazon.com");

        //Sayfa basligini consola yazdiriniz
        String amazonActualTitle = driver.getTitle(); //Gidilen sayfanin basligini verir
        System.out.println("Amazon Sayfasi Basligi : " +amazonActualTitle);

        //Sayfanin Url ini consola yazdiriniz
        String amazonActualUrl = driver.getCurrentUrl(); //-->Gidilen sayfanin Url ini verir
        System.out.println("Amazon Sayfasi Url'i = " + amazonActualUrl);

        //Techproeducation sayfasina gidiniz
        driver.get(techprourl);

        //Sayfa basligini consola yazdiriniz
        String techproActuelTitle = driver.getTitle();
        System.out.println("Techpro Sayfa Basligi = " + techproActuelTitle);

        //Sayfanin Url ini consola yazdiriniz
        String techproActuelUrl = driver.getCurrentUrl();
        System.out.println("Techpro Sayfasi Url'i = " + techproActuelUrl);









    }
}
