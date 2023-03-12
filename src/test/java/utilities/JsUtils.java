//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JsUtils {
    public JsUtils() {
    }

    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor)Driver.getDriver();
        jsexecutor.executeScript("arguments[0].click();", new Object[]{element});
    }

    public static String getTitleByJS() {
        JavascriptExecutor jsexecutor = (JavascriptExecutor)Driver.getDriver();
        String title = jsexecutor.executeScript("return document.title;", new Object[0]).toString();
        return title;
    }

    public static void scrollDownByJS() {
        JavascriptExecutor jsexecutor = (JavascriptExecutor)Driver.getDriver();
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)", new Object[0]);
    }

    public static void scrollAllUpByJS() {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)", new Object[0]);
    }

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor)Driver.getDriver();
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
    }

    public static void changeColor(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", new Object[]{element});

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }

    public static void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundcolor");

        for(int i = 0; i < 5; ++i) {
            changeColor("rgb(0,200,0", element);
            changeColor(bgColor, element);
        }

    }

    public static void flash(WebElement element, int iteration) {
        iteration = iteration <= 0 ? 1 : iteration;
        String bgColor = element.getCssValue("backgroundcolor");

        for (int i = 0; i < iteration; ++i) {
            changeColor("rgb(0,200,0", element);
            changeColor(bgColor, element);
        }
    }

    public static void generateAlert(String message) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
        javascriptExecutor.executeScript("alert('" + message + "')", new Object[0]);
        Thread.sleep(3000L);
    }

    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript(command, new Object[]{element});
    }

    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript(command, new Object[0]);
    }

    public static void setValueByJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", new Object[]{element});
    }

    public static void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value", new Object[0]).toString();
        System.out.println(value);
    }

    public static void addBorderWithJS(WebElement element, String borderStyle) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].style.border='" + borderStyle + "'", new Object[]{element});
    }
}