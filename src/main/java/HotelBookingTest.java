import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

public class HotelBookingTest {

WebDriver driver;
	
	@BeforeMethod
    public void beforeMethod(){
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
     }


	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@Test
	public void shouldBeAbleToSearchForHotels() {
		setDriverPath();
		
		PageFactory.initElements(driver, this);


		driver.get("https://www.cleartrip.com/");
		hotelLink.click();

		localityTextBox.sendKeys("Indiranagar, Bangalore");

		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();

		driver.quit();

	}

	@BeforeSuite
	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			System.out.println(System.getProperty("webdriver.chrome.driver"));
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}

}
