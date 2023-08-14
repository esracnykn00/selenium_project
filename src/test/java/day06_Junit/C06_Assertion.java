package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        /*
        1)https://www.youtube.com adresine gidin
        2)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
          => Sayfa başlığının “YouTube” oldugunu test edin
          => YouTube resminin görüntülendiğini (isDisplayed()) test edin
              ○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
              ○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
         */
    }

    @Test
    public void test01() {
        // => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals("YouTube",driver.getTitle());

        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test02() {
        //○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[3]"));
        Assert.assertTrue(searchBox.isEnabled());

    }

    @Test
    public void test03() {
        //○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin (olmadigini dedigi icin)
        Assert.assertNotEquals("youtube", driver.getTitle());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}