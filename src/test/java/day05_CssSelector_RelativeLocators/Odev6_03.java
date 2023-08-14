package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev6_03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        // 2. Username kutusuna “standard_user” yazdirin
        WebElement username = driver.findElement(By.xpath("//*[@type='text']"));
        username.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        //4. Login tusuna basin
        WebElement login = driver.findElement(By.xpath("//*[@id='login-button']"));
        login.click();
        Thread.sleep(2000);
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        ilkUrun.click();
        Thread.sleep(2000);
        //6. Add to Cart butonuna basin
        WebElement cart = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
        cart.click();
        Thread.sleep(2000);
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        Thread.sleep(4000);
        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //manuel olarak kontrol ediyorum
        // 9. Sayfayi kapatin
        driver.close();



















    }
}
