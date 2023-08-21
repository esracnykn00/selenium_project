package tasklar_quizler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class task_02 extends TestBase {
/*
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
      başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

 */

    @Test
    public void test01() {

        //-Amazon sayfasına gidelim
        driver.get("http://amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//select[@name='url']"));
        Select select = new Select(ddm);
        List<WebElement> menuList = select.getOptions();
        menuList.forEach(t-> System.out.println(t.getText()));

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        List<WebElement> listedekiler = select.getOptions();

        for (int i=1; i<6; i++){
            listedekiler.get(i).click();
            System.out.println(i + ".Title : " + driver.getTitle());
            driver.navigate().back();
        }






    }
}
