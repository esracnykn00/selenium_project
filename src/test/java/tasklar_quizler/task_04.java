package tasklar_quizler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class task_04 extends TestBase {

    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    //New Tab butonunun görünür olduğunu doğrula


    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        WebElement secenek = driver.findElement(By.xpath("(//h5)[3]"));
        secenek.click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String actuelYazi = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']")).getText();
        String expectedYazi = "Please select an item from left to start practice.";
        Assert.assertTrue(expectedYazi.equals(actuelYazi));

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        //New Tab butonuna click yap
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        newTab.isDisplayed();
        newTab.click();
        bekle(2);

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        window(1);
        WebElement yeniYazi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(yeniYazi.isDisplayed());
        bekle(2);

        //İlk Tab'a geri dön
        window(0);

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab2 = driver.findElement(By.cssSelector("button[id='tabButton']"));
        newTab2.isDisplayed();













    }
}
