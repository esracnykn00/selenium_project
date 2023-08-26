package day15_ExtentReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {
    /*
    Eger bir sayfada icinde datalarin bulundugu bir tablo ile karsilasirsak;
           1) <table> tag'i ile basliyorsa bu tag bize tum tabloyu verir. xpath ile //table yazarak
           sayfada kac tane tablo oldugunu tespit eder birden fazla tablo varsa (//table)[index] ile
           istedigimiz tabloyu bu sekilde locate edip getText() methodu ile yazdirabiliriz.
           2) <thead> table tag'indan sonra bu tag var ise tablodaki basliklari thead tag'i ile alabiliriz
           <thead> tag'indan sonra <tr>(table row) tag'i basliktaki satir'i, <th> tag'i ise basliktaki
           her bir hucreyi temsil eder.
           3) <tbody> thead tag indan sonra


     */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        WebElement tablo1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println(tablo1.getText());

        //Task 2 : 3. Row' datalarını print edin  Task 3 : Son row daki dataları print edin
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[3]"));
        System.out.println("Ucuncu Satir Verileri : "+ucuncuSatir.getText());

        //Task 3 : Son rowdaki datalari print edin.
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        /*
           Xpath kullaniminda eger bir webtable'da son satir bilgisi istenirse yukaridaki ornekteki gibi
        satir icindeki index yerine last() function kullanabilirsiniz.
         */
        System.out.println("Son Satir Verileri : "+sonSatir.getText());

        //Task 4 : 5. Column datalarini print edin
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("Beşinci Sütundaki Başlık : "+besinciBaslik.getText());
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(e-> System.out.println(e.getText()));

        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin
        printData(2,3);
    }

    private void printData(int satir, int sutun) {
        System.out.println("*********************************************");
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }

    /*
    ODEV:
          3.satirdaki 1. ve 2. sutun bilgilerini yazdiriniz. --> position()>=1 and position()<=2 gibi
     */
}
