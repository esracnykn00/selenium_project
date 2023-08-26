package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void test01() {
        /*
        NoSuchElementException:
             1-) Yanlis locate almis olabilirsiniz. Dolayisiyla locate'i duzeltmeniz gerekir
             2-) Locate'ini aldiginiz webelelement iframe icinde olabilir. Dolayisiyla iframe gecis yapamiz gerekebilir.
             3-) Bir tiklama isleminden sonra yeni bir pencere acildiysa driver'i o pencereye gecirmezsek bu hatayi
             aliriz. Dolayisiyla pencere gecisi yapmaniz gerekebilir.
             4-) Locate etmek istedigimiz webelement sayfanin altinda ise bazen bazi sayfalar scroll yapmadan
             bu webelementi goremez. Dolayisiyla driver'a elementi gostermeniz gerekir.
         */
        driver.get("http://techproeducation.com");
        WebElement aramaKutusu = driver.findElement(By.xpath("faseedfsdf"));
        aramaKutusu.sendKeys("java");
    }
}
