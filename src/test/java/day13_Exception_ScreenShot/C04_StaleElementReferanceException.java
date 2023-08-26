package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {
    @Test
    public void test01() {
        /*
        STALEELEMENTREFERENCEEXCEPTION
              Bir webelementi locate ettikten sonra sayfada refresh(navigate.refresh),back() ya da forward() islemi
          yaptiysaniz ve tekrar locate'ini aldiginiz webelementi kullanmak isterseniz bu hatayi alirsiniz.
          Cunku sayfa yenileme, sayfada ileri geri yapma isleminden sonra driver locate'ini aldiginiz elementi
          eskimis element olarak gorur ve bu hatayi handle etmek icin o elementi tekrar locate etmeniz gerekir.
              List<Webelement> linkler = driver.findElement(By.xpath("sdfgs"));
              Yukaridaki linklerin oldugu listeyi bir loop icinde hepsine click yapicaz.
              for(i=0; i<linkler.size(); i++){
              linkler.get(i),click;
              driver.navigate().back();
              linkler = driver.findElements(By.xpath("sdfsdf"))-->Eğer tekrar liste atama yapmazsak aynı şekilde
              listin içindeki elementleri eskimis kabul edip STALEELEMENTREFERENCEEXCEPTION fırlatacak.
              Dolayısıyla loop içinde list'e tekrar elementlerin atamasını yaparsak bu exception'ı handle etmiş oluruz
         */

        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement link = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        link.click();
        bekle(2);

        //Back() ile ana sayfaya dönelim
        driver.navigate().back();
        bekle(2);

        //Tekrar Events linkine tıklayalım
        link.click();//-->StaleElementReferenceException

    }

    @Test
    public void test02() {
        driver.get("http://amazon.com");
        bekle(5);

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //Back() ile ana sayfaya dönelim
        driver.navigate().back();

        //Tekrar arama kutusunda samsung aratalım
        aramaKutusu.sendKeys("samsung", Keys.ENTER);

         /*
        refresh,back ve forward işlemlerinde sonra eğer elementin locate'ini tazelemezsek StaleElementReferenceException
        hatasını yukarıdaki örnekteki gibi alırız.
         */
    }

    @Test
    public void test03() {
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement link = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        link.click();
        bekle(2);

        //Back() ile ana sayfaya dönelim
        driver.navigate().refresh();
        bekle(2);

        //Tekrar Events linkine tıklayalım
        link.click();//-->StaleElementReferenceException
    }

    @Test
    public void test04() {
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement link = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        link.click();
        bekle(3);

        //Back() ile ana sayfaya dönelim
        driver.navigate().refresh();
        bekle(2);

        //Tekrar Events linkine tıklayalım
        WebElement linkler = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        linkler.click();//-->StaleElementReferenceException hatasi almadik cunku ust satirda yeniden bayatlayan
                        // web elementin yerine aynisi yeniden yazdirdim
    }

}

