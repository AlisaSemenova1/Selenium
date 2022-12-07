
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class DynamicallyLoadedPage {
    private WebDriverWait webDriverWait;
    WebDriver webDriver;
    final int TIMEOUT = 10;

    public DynamicallyLoadedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("https://the-internet.herokuapp.com/dynamic_loading");
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[contains( text(),'Example 2')]")
    public WebElement elementRenderedAfterTheFact;

    @FindBy(xpath = "//button")
    public WebElement buttonStart;

    @FindBy(xpath = "//*[@id='finish']/h4")
    public WebElement textAfterLoader;

    public void dynamicallyLoadedPageElement() {
        elementRenderedAfterTheFact.click();
        buttonStart.click();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(textAfterLoader));
        assert textAfterLoader.getText().equals("Hello World!");
    }

}
