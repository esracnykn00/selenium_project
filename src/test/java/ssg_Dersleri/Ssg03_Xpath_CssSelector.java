package ssg_Dersleri;

import day04_GetTagNameGetAttribute_Xpath_Css.Tekrar_02;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Ssg03_Xpath_CssSelector extends TestBase {

    @Test
    public void xpathTesti() {

        //XPath Basics
        driver.findElement(By.xpath("//*[@id='id1']"));
        driver.findElement(By.xpath("//*[@name='name1']"));
        driver.findElement(By.xpath("//*[@value='value1']"));
        driver.findElement(By.xpath("//p[@class=class1']"));

        // And
        driver.findElement(By.xpath("//p[@name='a' and @id='a']"));
        driver.findElements(By.xpath("//p[@name='a' or  @id='a']"));

        // Text
        driver.findElement(By.xpath("//p[text()='unique id']"));

        // Parent - Child
        driver.findElement(By.xpath("//div[@id='divA']/input"));
        driver.findElement(By.xpath("//div[@id='divA']/input[@type='text']"));
        driver.findElement(By.xpath("//div[@id='divC']//input")); // Torun

        // Index
        driver.findElement(By.xpath("//p[@name='a'][1]"));
        driver.findElement(By.xpath("(//input[@type='text'])[1]"));

        // Absolute Path
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[2]/form[1]/div[1]/input"));

        // Contains
        driver.findElement(By.xpath("//p[contains(text(), 'logged in successfully')]"));

    }

    @Test
    public void cssSelectorTesti() {

        //id

    }
}
