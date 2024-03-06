package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook_Loginpage 
{
	@FindBy(xpath="//input[@placeholder=\"Email address or phone number\"]")
	private WebElement un;
	
	@FindBy(xpath="//input[@placeholder=\"Password\"]")
	private WebElement pwd;
	
	@FindBy(name="login")
	private WebElement loginbtn;
	
	//Initialization
	public Facebook_Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getUn() {
		return un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void logintofb(String un1,String pwd1) {
		un.sendKeys(un1);
		pwd.sendKeys(pwd1);
		loginbtn.click();
		
	}
	
}
