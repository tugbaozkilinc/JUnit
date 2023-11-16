package utilities;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class TestBase {

    protected static WebDriver driver;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        waitFor(5);
        driver.quit();
    }

    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String w : driver.getWindowHandles()) {
            driver.switchTo().window(w);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    public static void switchToWindow(int windowIndex){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowIndex));
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    public static void hoverOverOnElementActions(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public static void scrollDownActions() {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    public static void scrollUpActions() {
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    public static void dragAndDropActions(WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    public static void dragAndDropActions(WebElement source, int x, int y) {
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickAbility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickAbility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void takeScreenShotOfPage() {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshotOfElement(WebElement element) {
        File image = element.getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollEndJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollTopJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void typeWithJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '" + text + "');", element);
    }

    public void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println("The value in the box is: " + text);
    }

}
