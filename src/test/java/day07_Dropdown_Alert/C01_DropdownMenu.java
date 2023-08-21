package day07_Dropdown_Alert;

import com.google.gson.stream.JsonToken;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu {

    /*
           Dropdown menu; alt basliklarin listelendigi sayfadaki bir webelemente denir.
      Dropdown webelementine sendKeys() methodu ile listede bulunan seceneklerden istedigimizi gonderebiliriz.
      Gonderemedigimiz durumlarda Select classindan bir object olusturarak bu olusturdugumuz objeye
      parametre olarak locate ettigimiz dropdown web elementini yazariz. Bu olusturdugumuz obje ile byIndex,
      byvisibletext ve byValue methodlari ile dropwown menudeki seceneklerden istedigimizi secebiliriz.
      getOptions() methodu ile tum dropdown menudeki secenekleri listeleyebiliriz.
      getFirstSelectedOptions()-->ilk secenegi al
        getFirstSelectedOptions() methodu ile dropdown menude ilk secili olan secenegi getirir.
        Bir Dropdown menu <select> tag'ına sahip değilse Select class'ını kullanamazsınız
     */



    /*
         Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        -3 farklı test methodu oluşturalım
         1.Method:
             a. Yil,ay,gün dropdown menu'leri locate ediniz
             b. Select objesi olustur
             c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void test01() {
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay = driver.findElement(By.cssSelector("select#month"));
        WebElement gun = driver.findElement(By.cssSelector("select#day"));

        ay.sendKeys("May"); //-->May i kucuk harfle de kabul ediyor ama
        // bazi siteler kabul etmez casesensitive dir

        //b. Select objesi olustur
        Select selectyil = new Select(yil);
        Select selectay = new Select(ay);
        Select selectgun = new Select(gun);

        //c. Select object i kullanarak 3 farkli sekilde secim yapiniz
        selectyil.selectByIndex(5);
        selectay.selectByVisibleText("May");
        selectgun.selectByValue("22");
    }

    @Test
    public void test02() {
        //a. Tüm eyalet isimlerini yazdıralım
            WebElement eyaletler = driver.findElement(By.cssSelector("select#state"));
            Select select = new Select(eyaletler);
            List<WebElement> eyaletListesi = select.getOptions();
            //eyaletListesi.forEach(t-> System.out.println(t.getText()));  //--> Lambda ile yazdirdim
        for (WebElement each : eyaletListesi){
            System.out.println(each.getText());
        }
      }

    @Test
    public void test03() {
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state = driver.findElement(By.cssSelector("select#state"));
        Select select = new Select(state);
        String seciliOlanSecenek = select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State",select.getFirstSelectedOption().getText());
        //assertequals la iki secenegin de esit oldugunu dogrulamis oldum

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //driver.close();
    }
}
