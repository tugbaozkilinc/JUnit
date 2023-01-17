package day05;

import org.junit.*;

public class C04_BeforeClassAfterClass {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Butun test lerden once calisti.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Butun test lerden sonra calisti.");
    }

    @Before
    public void setUp() {
        System.out.println("Her testten once calisir");
    }

    @After
    public void teardown() {
        System.out.println("Her testten sonra calisir");
    }

    @Test
    public void test01() {
        System.out.println("Ilk test");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci test");
    }

    @Test
    @Ignore
    public void test03() {
        System.out.println("Ucuncu test");
    }

}
