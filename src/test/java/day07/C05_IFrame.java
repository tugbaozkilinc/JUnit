package day07;

import org.junit.Test;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    // IFrame, bir web sayfasınin icine yerlestirilmis baska bir web sayfasıdır veya bir HTML dokumaninin içine yerleştirilmiş baska bir HTML dokumanidir.
    // IFrame genellikle bir Web sayfasına dokuman, video veya interaktif media gibi başka bir kaynaktan içerik eklemek için kullanılır. <iframe> tag’ı bir inline frame belirtir.

    @Test
    public void iframeTest() {
        // https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        // Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim.
        // Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim.
        // Son olarak footer daki ‘Povered By’ yazisinin varligini test edelim.
    }

}
