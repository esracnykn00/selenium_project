package tasklar_quizler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class task_06 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        /*
          -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
          -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
          -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
          -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
          -Çıkan alert'te iptal butonuna basınız
          -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
          -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
          -Çıkan mesajı konsola yazdırınız
          -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
         */

        driver.get("http://demo.automationtesting.in/Alerts.html");
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Erol");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());
        Assert.assertEquals("Hello Erol How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());
    }
}
