package day13_Exception_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Condition;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        /*
    SCREENSHOT
    Selenium da tüm sayfanın resmini alabilmek için;
        1-TakeScreenShot arayüsünden bir obje oluşturup driver'a eşitleriz
        Farklı arayüzler olduğu için casting yaparız.
        2-FileUtils class'ından copyFile() method'u içe parametre olarak
        oluşturmuş olduğumuz obje ile getScreenShotAs() methodunu kullanır getScreenShotAs() methoduna
        parametre olarak OutputType.FILE ekleriz ve bunu yeni bir dosyaya kaydetmesi için
        new File() diyerek resmi kaydedeceğimiz dosyanın yolunu belirtiriz
 */
        //Amazon sayfasına gidelim
        driver.get("hhtp://amazon.com");

        //Tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("utilities/TumSayfaResimleri/screenShot.jpeg"));
    }

    @Test
    public void test02() throws IOException {
        //Techpro sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Tum sayfanin ekran goruntusunu alalim
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "utilities/TumSayfaResimleri/techProScreenShot.jpeg";
        File file = new File(dosyaYolu);
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),file); //belirtmis oldugum dosyayolundaki copufile methoduyla kopyaliyorum
                                                                      //suan objeyi olusturmus oldum getscr.. methoduna paramere ekliyorum
                                                                      //output olrak ve yeni dosya ekliyorum artik.ustte getirdigim.
    }

    @Test
    public void test03() throws IOException {

        //facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        //Tüm sayfanın ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "target/facebookScreenShot.png"; //Not: resim olarak kaydetmesi icin dosya ismini ".png" veya ".jpeg" ile bitirmeliyiz.
                                                            //once jpeg sonra png denedim ikisini de fakrli kaydetti cunku farkli uzantilar
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
