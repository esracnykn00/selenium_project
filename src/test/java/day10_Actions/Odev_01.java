package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev_01 extends TestBase {
    @Test
    public void test01() {

          /*
        ÖDEV:
        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
         */

        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        actions.moveToElement(aramaKutusu);
        bekle(2);
        actions.clickAndHold().perform();
        actions.sendKeys("Selenium", Keys.ENTER).contextClick().perform();
        WebElement aramaKutusu2 = driver.findElement(By.id("APjFqb"));
        actions.doubleClick(aramaKutusu2).perform();





    }
}
