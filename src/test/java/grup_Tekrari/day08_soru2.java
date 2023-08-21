package grup_Tekrari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class day08_soru2 extends TestBase {

    /*
    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
      1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
      3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      4.Tüm dropdown değerleri(value) yazdırın
      5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
      False yazdırın.
     */

    @Test
    public void test01() {
       //●https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement secenek1 = driver.findElement(By.xpath("//select[@id='dropdown']"));
        secenek1.click();
        Select select = new Select(secenek1);
        select.selectByIndex(1);
        String option1 = select.getFirstSelectedOption().getText();
        System.out.println(option1);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
       WebElement secenek2 = driver.findElement(By.xpath("//select[@id='dropdown']"));
       secenek2.click();
       Select select1 = new Select(secenek2);
       select1.selectByValue("2");
       String option2 = select1.getFirstSelectedOption().getText();
        System.out.println(option2);

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        bekle(2);
        select.selectByVisibleText("Option 1");
        String visibleText = select.getFirstSelectedOption().getText();
        System.out.println(visibleText);

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmlist = select.getOptions();
        ddmlist.forEach(t-> System.out.println(t.getText()));

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //      False yazdırın.

        int boyut  = ddmlist.size();

        if (boyut == 4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }


    }
}
