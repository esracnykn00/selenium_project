package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_3 {
    public static void main(String[] args) {

         //Amazon sayfasına gidiniz
        //Arama kutusunu locate ediniz ve iphone yazdırıp aratınız
        //Sayfayı kapatınız

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.sendKeys("iphone");
        //aramaKutusu.submit();
        aramaKutusu.sendKeys("iphone",Keys.ENTER);











































    }
}
