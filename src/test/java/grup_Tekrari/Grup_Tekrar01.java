package grup_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Grup_Tekrar01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");
        Thread.sleep(2000);
        driver.get("http://www.walmart.com/");
        System.out.println("Sayfa basligi : "+driver.getTitle());
        System.out.println("Sayfa Urlsi : "+driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.navigate().back();

        driver.close();


    }
}