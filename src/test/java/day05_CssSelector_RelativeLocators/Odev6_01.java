package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev6_01 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //Add Element butonuna basin
        //Delete butonu'nun gorunur oldugunu test edin
        //Delete tusuna basin
        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin

         /*   ÖDEV:
           https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
           Add Element butonuna 100 kez basınız
           Delete butonuna 90 kez basınız
           Ve 90 kez basıldığını doğrulayınız
 */
        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna basin 100 kez basınız

       for (int i=0 ; i<100; i++) {
           WebElement addElementKutusu = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
           addElementKutusu.click();
       }

        //Delete butonuna 90 kez basınız

        int deleteButonu=0;
        for (int i=0 ; i<90; i++){
            driver.findElement(By.xpath("//button[@class='added-manually']")).click();
            deleteButonu++;
        }

        // Ve 90 kez basıldığını doğrulayınız
        if (deleteButonu==90){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
































    }
}
