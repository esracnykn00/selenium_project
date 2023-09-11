package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void test01() {

        /*
         SELENIUM WAIT:
             IMPLICITLY WAIT : Driver'i oluşturduktan sonra sayfadaki tüm elementlerin etkileşime girebilmesi için
         belirtilmiş olduğumuz max. süre kadar bekler (Duration.ofSecond(15)).
             EXPLICT WAIT / WebDriverWait --> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
         max. belirtmiş olduğumuz süre kadar default olarak yarım saniyelik aralıklar ile bekler. Örneğin bir
         webelemente tıkladıktan sonra bir alert'ün yada bir webelementin oluşması zaman alabilir. Ve testimizi
         her çalıştırdığımızda bu zaman değişkenlik gösterebilir dolayısıyla bu gibi durumlarda Thread.sleep() methodu
         işimize yaramayabilir. Bu gibi durumlarda webdriverwait ile max. belirttiğimiz süre boyunca elementin
         etkileşime girmesini bekletebiliriz.
             Explicit Wait ile birde fluentWait kullanımı vardır. WebDriverWait ile arasındaki fark fluentwaitte
         bekleme aralığını kendimiz belirleriz

          */


        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        /*
        1-) Hangi webelementi gorunur olana kadar beklemek istiyorsak o webelemenntin locate'ini aliriz.
        2-) WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); wait objecti olustururuz.
        3-) wait objesi ile until(e kadar) methodu ile parametre olarak bekleme koşunu ExpectedConditions class'ındaki
        methodlarla belirtiriz
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!",helloWorldWE.getText());
        /*
         özetle explicit wait yarım saniye aralıklarla kontrol ettiği için ve çalışır çalışmaz
        alt satıra geçtiği için dinamik kod oluyor Thread.sleep yerine
         */
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        /*
        Locate'ini aldigim yukaridaki we i gorunur olana kadar bekle
         */
        Assert.assertEquals("Hello World!",helloWorldWE.getText());
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }
    /*
    HOMEWORK:
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıkla
    loading webelementi kaybolana kadar bekleyelim
    Hello World! Yazının sitede oldugunu test et
     */

    /*
    public WebElement waitUntilVisibilityOfWE2 (int beklemeSuresi, String elementXpath){
    return
            new WebDriverWait(myChrome, Duration.ofSeconds(beklemeSuresi))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath) ));

                konuyu anlayinca testbase de bu sekilde method olusturabiliriz
     */
}
