package tasklar_quizler;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class task_03 extends TestBase {

    /*
    -https://the-internet.herokuapp.com/windows sayfasına gidiniz

    -Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz

    -Elemental Selenium linkine tıklayınız

    -Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz

    -Url'in https://elementalselenium.com/ olduğunu doğrulayınız

    "

    A free weekly email of tips to help make
    Selenium one of the most robust browser
    automation tools out there.
    "
    -Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız
    -Language dropdown menuden java seçiniz
    -Join the mailing list buttonuna tıklayınız
    -Sayfada Thank you! yazısının çıktığını doğrulayınız
     */

    @Test
    public void test01() {

        //-https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows");

        //-Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        elementalSelenium.isDisplayed();

        //-Elemental Selenium linkine tıklayınız
        elementalSelenium.click();

        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz.
        window(1);
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

        //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız
        Assert.assertTrue(driver.getCurrentUrl().contains("https://elementalselenium.com/"));

        //-Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız
        WebElement mail = driver.findElement(By.xpath("//*[@id='email']"));
        mail.sendKeys("ronen.exodus@feerock.com",Keys.TAB);

        //-Language dropdown menuden java seçiniz
        WebElement language = driver.findElement(By.className("dropdown-language"));
        Select select = new Select(language);
        select.selectByVisibleText("Java");

        //-Join the mailing list buttonuna tıklayınız
        driver.findElement(By.xpath("(//input)[2]")).click();

        //-Sayfada Thank you! yazısının çıktığını doğrulayınız
        String actuel = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertTrue(actuel.contains("Thank you!"));





    }
}
