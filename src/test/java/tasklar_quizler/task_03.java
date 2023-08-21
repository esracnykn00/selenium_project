package tasklar_quizler;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

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



    }
}
