package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebelementLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Techpro sayfasina gidelim
        //arama kutusunda java aratalim
        //cikan seceneklerden full stack java developer secenegine tiklayalim
        //basligin java icerdigini test edelim
        //sayfada kac tane link oldugunu consola yazdiralim
        //sonra linkleri consola yazdiralim
        //sayfayi kapatiniz
        driver.get("http://techproeducation.com");
        driver.findElement(By.id("searchHeaderInput")).sendKeys("java");
        Thread.sleep(3000);
        List<WebElement> javaDeveloperListesi = driver.findElements(By.linkText("Full Stack Java Developer"));
        /*
        Linktext'i Full Stack Java Developer olan butun webelementleri bir javaDeveloperListesi isimli liste attim.
        Web sayfasi uzerinden yukari asagi ok tuslari ile hangi webelement tiklamak istedigim webelement ise onu
        4.de bulduk. List'te index 0 dan basladigi icin 3.element benim istedigim element olacaktir.
         */
        javaDeveloperListesi.get(0).click();

        if (driver.getTitle().contains("Java")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        /*
        Tag'i a olan webelementlerin hepsini bir liste attik. List kullaniminda birden fazla webelemente ulasmak
        istedigimiz icin findElement() methodu yerine findElements() methodunu kullaniriz.
         */
        System.out.println("Sayfadaki Linklerin Sayisi: "+linkler.size());

        for (WebElement w: linkler) {
            if (!w.getText().isEmpty()) {
                System.out.println(w.getText());
            }
        }
        /*
        Bir webelementin sahip oldugu text i yazdirmak isterseniz getText() methodunu kullanmaniz gerekir.
         */

        //Lambda ile :
        linkler.forEach(t-> System.out.println(t.getText())); //bosluk olmasin istiyosan yine araya bi if eklemem gerekir
        linkler.forEach(link->{if (!link.getText().isEmpty()){System.out.println(link.getText());}});

        driver.close();

















    }
}
