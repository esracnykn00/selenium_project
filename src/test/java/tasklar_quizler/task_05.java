package tasklar_quizler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class task_05 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        /*
        - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        - Çizimden sonra clear butonuna basınız
        - Sayfayi kapatiniz

         */


        driver.get("http://szimek.github.io/signature_pad/");

        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(yaziTahtasi);

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        actions.release().build().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();


    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("http://szimek.github.io/signature_pad/");

        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(yaziTahtasi);

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,0);
        }
        actions.release().build().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
    }
}
