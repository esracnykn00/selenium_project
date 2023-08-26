package tasklar_quizler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class task_01 extends TestBase {
/*
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
*/

    @Test
    public void test01() {

            // https://ebay.com sayfasına gidiniz
            driver.get("https://ebay.com");


            // electronics bolumune tıklayınız

            driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();


            // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

            List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

            for (int i = 0; i < resimler.size(); i++) {

                resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

                resimler.get(i).click();

                System.out.println(i + ".Title : " + driver.getTitle());

                driver.navigate().back();

            }
        }


}

