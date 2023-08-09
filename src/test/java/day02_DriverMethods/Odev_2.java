package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_2 {
    public static void main(String[] args) throws InterruptedException {

        //Amazon soyfasina gidelim. https://www.amazon.com/
        //Sayfanin konumunu ve boyutlarini yazdirin
        //Sayfayi simge durumuna getirin
        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        //Sayfayi fullscreen yapin
        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        //Sayfayi kapatin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");
        driver.navigate().refresh();
        System.out.println("Sayfanin Konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanin Olculeri : "+driver.manage().window().getSize());
        driver.manage().window().minimize();
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        System.out.println("Sayfanin Konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfnin Boyutu : "+driver.manage().window().getSize());
        driver.manage().window().fullscreen();
        System.out.println("Sayfanin Konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanin Boyutu : "+driver.manage().window().getSize());

        driver.close();



    }
}
