package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //techproeducation sayfasına gidelim
        //Arama kutusunu locate edelim
        //arama kutusunun tag name'inin input olduğunu test edelim
        //arama kutusunun class attributenin degerinin form-input oldugunu test ediniz.
        //sayfayi kapatiniz

        driver.get("http://techproeducation.com");

        //<input id="searchHeaderInput" type="text" class="form-input" placeholder="Search Program">
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));
        System.out.println("Arama Kutusu Webelementi Tag Name'i : "+aramaKutusu.getTagName());
        String gercekTagName = aramaKutusu.getTagName();
        String beklenenTagName = "input";
        if (gercekTagName.equals(beklenenTagName)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        String gercekAttributeName = aramaKutusu.getAttribute("class");
        System.out.println("Class Attribute Degeri : "+gercekAttributeName);  //form-input
        String beklenenAttributeDegeri = "form-input";
        if (gercekAttributeName.equals(beklenenAttributeDegeri)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

       driver.close();


    }
}
