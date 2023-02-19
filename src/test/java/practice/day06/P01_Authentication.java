package practice.day06;

import org.junit.Test;
import utilities.TestBase;

public class P01_Authentication extends TestBase {

    @Test
    public void name() {
        //http://httpbin.org/basic-auth/foo/bar adresine gidiniz
        //Username  : foo
        //password  : bar
        //Yukardaki verileri kullanarak güvenliği geçin
        driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");
    }

}
