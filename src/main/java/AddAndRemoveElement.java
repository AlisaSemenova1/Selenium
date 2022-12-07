
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddAndRemoveElement {
    private WebDriverWait webDriverWait;
    WebDriver webDriver;
    final int TIMEOUT = 10;

    public AddAndRemoveElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "#content > div > button")
    public WebElement buttonAddElement;

    public void addAndRemoveElement(int count) {
        for (int addElem = 0; addElem < count; addElem++) {
            buttonAddElement.click();
        }
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='elements']/button"), count));
    }
}
