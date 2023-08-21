package grup_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Grup_Tekrari05 {
    public static void main(String[] args) {

        // maximize iken pencere konumunu ve pencere olcusunu yazdiriniz
        // fullscreen iken pencere konumunu ve pencere olcusunu yazdiriniz
        // sayfayi kapatiniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Pencerenin Konumu : "+driver.manage().window().getPosition());
        System.out.println("Pencerenin Olcusu : "+driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        System.out.println("Pencerenin Konumu : "+driver.manage().window().getPosition());
        System.out.println("Pencerenin Olcusu : "+driver.manage().window().getSize());

        driver.close();





    }
}
