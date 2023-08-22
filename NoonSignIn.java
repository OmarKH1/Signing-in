package testingNoon;

import static org.junit.Assert.*;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoonSignIn {
	WebDriver driver;
	String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		this.driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		baseURL = "https://www.noon.com/egypt-en/?utm_source=C1000088L&utm_medium=cpc&utm_campaign=C1000151355N_eg_en_web_searchxxexactandphrasexxbrandpurexx08082022_noon_web_c1000088l_acquisition_sembranded_&gclid=CjwKCAjw29ymBhAKEiwAHJbJ8l84LQDKEIz2AWkDUvJVy5NR-U-CATPqlBWvNwhJLPXLa_zEOpInWhoCoVEQAvD_BwE";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		
	}
	
	@Test
	public void test() throws Exception {
		String username ="Omarkhafagy69@gmail.com";
		String password ="Nightmare_10";
		String shoes = "adidas";
		//Finding and clicking on "Sing in" button 
		driver.findElement(By.xpath("//span[@class=\'userText\']")).click();
		//Entering username and password and then clicking on "sign in"
		driver.findElement(By.id("emailInput")).sendKeys(username);
		driver.findElement(By.id("passwordInput")).sendKeys(password);
		driver.findElement(By.id("login-submit")).click();
		
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Waiting until the search bar being available to be clicked on and then entering the word "adidas"
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBar")));
		Thread.sleep(5000);
		search.sendKeys(shoes);
		//waiting until the list appears and be available to be clicked on and choose "adidas shoes for men"
		WebElement searchbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//*[@id=\"__next\"]/div/header/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div")));
		searchbox.click();
		Thread.sleep(4000);
		//After the page is loaded, it scrolls down to the desired product  
		js.executeScript("window.scrollBy(0,1500);");
		driver.findElement(By.xpath("//div[@title='Adidas Grand Court TD Lifestyle Court Casual Shoes ']")).click();
		Thread.sleep(3000);
		//After clicking on the product the the page scrolls down where the size button is shown
		js.executeScript("window.scrollBy(0,750);");
		WebElement sizelist = driver.findElement(By.xpath("//div[@class='sc-35035e54-1 djqwPY section']  //div[@id='selectBoxFromComponent']//div[@class=' css-10bh5jj-control']"));
		sizelist.click();
		Thread.sleep(1000);
		//Scrolling down to the end of the size list to choose the size 
		actions.moveToElement(sizelist);
		actions.sendKeys(Keys.END).perform();
		driver.findElement(By.xpath("//div[@id = 'react-select-selectBoxFromComponent-option-10']")).click();
		Thread.sleep(3000);
		//Scorlling down again since after choosing the suitable size the page scrolls up and "add to cart" button is slightly below
		js.executeScript("window.scrollBy(0,750);");
		Thread.sleep(1000);
		//Clicking on "add to cart" button
		driver.findElement(By.xpath("//div[@class = 'loaderCtr inactiveLoading']")).click();
		Thread.sleep(2000);
		//Clicking on the "checkout" button that appears after clicking on "add to cart" 
		driver.findElement(By.id("checkout-btn")).click();
		
	}

	@After
	public void tearDown() throws Exception {
		
		
		
	}

	

}
