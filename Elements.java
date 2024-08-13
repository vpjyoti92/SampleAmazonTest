package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Class include all the elements of the class
 * @author Jyoti Pareek
 *
 */
public class Elements {

	static String altContent="Boldfit N95 Face Mask For Men & Women N95 Mask With 5 Layer N95 Masks For Adults & Kids N 95 Mask Face Mask Men Anti Pollu...";

	public Elements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
	static WebElement SearchInput;

	@FindBy(how = How.XPATH, using = "//input[@id='nav-search-submit-button']")
	static WebElement SearchSubmit;

//	@FindBy(how = How.XPATH, using = "//img[@alt='"+altContent+"']")
//	static WebElement ElementToBeSelected;

	@FindBy(how = How.XPATH, using = "//span[@class='a-price-whole']")
	static WebElement Price;

	@FindBy(how = How.XPATH, using = "(//a[@id='sellerProfileTriggerId'])[1]")
	static WebElement Dealer;

}
