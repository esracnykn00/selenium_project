package ssg_Dersleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Ssg01_JUnit extends TestBase {
/*
    https://www.kitapyurdu.com/ adresine gidiniz.
    Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
    Anasayfanın açıldığını sayfa başlığı ile doğrulayınız (“Kitapyurdu, Kitapla buluşmanın en kolay yolu”).
    Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
    Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
            “Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
    Haftanın Yayınevi bölümündeki kitap resimlerinin genişliklerinin 120 olduğunu doğrulayınız.
    */

    @Test
    public void test01() {
        //https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");

        //Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
        String  actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.kitapyurdu.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

        //Anasayfanın açıldığını sayfa başlığı ile doğrulayınız (“Kitapyurdu, Kitapla buluşmanın en kolay yolu”).
        String  actualTitle = driver.getTitle();
        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        Assert.assertEquals(expectedTitle, actualTitle);

       // Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
        String pageSource = driver.getPageSource(); //-->getPageSource methodu incelenen web sayfasinin tum sayfa kodunu bize verir.
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

        //Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        WebElement girisButonu = driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        String girisButonuMetni = girisButonu.getText();
        Assert.assertEquals("Giriş Yap",girisButonuMetni);

        //“Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlButonuHref = uyeOlButonu.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register",uyeOlButonuHref);

        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        List<WebElement> yazarListesi = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement yazarIsmi : yazarListesi){
            Assert.assertEquals("span",yazarIsmi.getTagName());
        }

        // En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğu doğrulanır
        for (WebElement yazarIsmi : yazarListesi){
            Assert.assertEquals("Arial, Helvetica, sans-serif", yazarIsmi.getCssValue("font-family"));
        }

        // Haftanın Yayınevi bölümündeki kitap resimlerinin genişliklerinin 120 olduğu doğrulanır
        List<WebElement> haftaninListesi = driver.findElements(By.xpath("//ul[@class='product-grid swiper-wrapper']//li//img"));
        for (WebElement resimler : haftaninListesi){
            Assert.assertEquals(120, resimler.getSize().getWidth());
        }





    }
}
