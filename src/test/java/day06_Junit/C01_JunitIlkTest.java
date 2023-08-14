package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JunitIlkTest {


    /*
                   Projemizde Junit frameworku kullanmak istiyorsak oncelikle https://mvnrepository.com adresinden Junit dependency'sini
               pom.xml dosyamiza koymamiz gerekiyor. Bu dependency sayesinde artik main method kullanmadan
               notasyonlar sayesinde test scriplerimizi yazacagiz. Notasyonlar @ isareti ile baslar @Test notasyonu icinde
               olusturacagimiz test methodunda kodlarimizi yazar ve calistiririz.
                    @Test notasyonuna sahip bir methodu hizli bir sekilde olusturmak istersek alt+insert
               tuslarina basarak test methodunu olusturabiliriz.
                    Junit frameworkunde testlerimi istediğimiz bir sıralamada çalıştırmak istersek alfabetik ve numerik
               olarak test methodlarının isimlerini belirtmemiz gerekir.
                 */
        @Test
        public void test01() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("http://techproeducation.com");
        }


        @Test
        public void test02() {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.get("http://amazon.com");
            }


        @Test
        public void test03() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
        }

        @Test
        public void test04() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
        }





















        }


















