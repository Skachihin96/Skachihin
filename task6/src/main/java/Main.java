import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    static WebDriver driver = null;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        try{
            driver.get("https://ya.ru");
            driver.findElement(By.name("text")).sendKeys("Задание 6 - выполнено!");
            driver.findElement(By.name("text")).sendKeys(Keys.ENTER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}