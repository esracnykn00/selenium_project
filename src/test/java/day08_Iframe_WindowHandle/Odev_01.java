package day08_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Odev_01 extends TestBase {

    @Test
    public void test01() {
         /*
    HOMEWORK:
 https://html.com/tags/iframe/   bu sayfaya gidiniz youtube daki play butonuna basiniz
     */

        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();














    }
}
