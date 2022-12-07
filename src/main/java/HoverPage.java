
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverPage {
    private final WebDriver webDriver;
    private WebDriverWait webDriverWait;
    final int TIMEOUT = 10;

    public HoverPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("https://the-internet.herokuapp.com/hovers");
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//img[@alt='User Avatar']")
    public WebElement userAvatar;

    @FindBy(xpath = "//a[contains(text(),'View profile')]")
    public WebElement textUnderUserAvatar;

    public void hoverToUser() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(userAvatar).perform();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(textUnderUserAvatar));
        if (textUnderUserAvatar.isDisplayed()) {
            System.out.println("Текст отображается");
        } else {
            System.out.println("Текст не отображается");
        }
    }

}


