package day17_JSExecutor;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.logging.Logger;

public class C05_Log4j extends TestBase {

    /*
        1-log4j kullanabilmek için src>main>resources package'ı altında log4j2.xml dosyası oluşturduk.
        2-log4j2.xml dosyası içerisine pdf deki adrestede bulunan xml kodlarını yapıştırdık
        3-log4j-api ve log4j-core dependency lerini pom.xml dosyasına ekledik.
​
    Ve test methodumuzda loglama işlemeri için Logger arayüzünden bir obje oluşturup, LogManager class'ından
    getLogger() methodu ile class'ımızı argumen olarak tanımlıycaz
     */
    @Test
    public void test01() {
        Logger logger = (Logger) LogManager.getLogger(C05_Log4j.class);
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        logger.info("Kullanıcı amazon sayfasına gitti");

        //arama kutusunda java aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("arama Kutusu locate edildi");
        aramaKutusu.sendKeys("java", Keys.ENTER);
        logger.info("aramaKutusunda java aratıldı");
    }
}
