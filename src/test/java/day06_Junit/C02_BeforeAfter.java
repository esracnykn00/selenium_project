package day06_Junit;

import org.junit.*;

import java.sql.SQLOutput;

public class C02_BeforeAfter {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Tum classtan once tek bir sefer calisir");
        System.out.println("**************************************");
    }


    @Before
    public void setUp2() throws Exception {
        System.out.println("Her methoddan önce bir kez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("Test01 çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("Test02 çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("Test03 çalıştı");
    }

    @Test
    public void test04() {
        System.out.println("Test04 çalıştı");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methoddan sonra bir kez çalışır");
        System.out.println("**************************************");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Tüm class'dan sonra tek bir sefer çalışır");
    }

    /*
    Bir classda 4 tane test methodu 1 tane before 1 tane after methodu varsa bu classta kac method calismstir?

     */



}
