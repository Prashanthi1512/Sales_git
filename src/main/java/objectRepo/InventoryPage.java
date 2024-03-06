package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage 
{
	//Declaration
	@FindBy(xpath="//input[@type='search']")
	private WebElement productsearch;
	@FindBy(xpath="//table[@id=\"dataTable\"]/tbody/tr[1]/td[1]")
	private WebElement pcode;
	
	@FindBy(xpath="//table[@id=\"dataTable\"]/tbody/tr[1]/td[3]")
	private WebElement quan;
	//Initialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getProductsearch() {
		return productsearch;
	}
	public WebElement getPcode() {
		return pcode;
	}
	
	public void searchProduct(String pname)
	{
		productsearch.sendKeys(pname);
		String code = pcode.getText();
		if(code.contains(pname))
		{
			System.out.println("product code updated "+pname);
		}
		else
		{
			System.out.println("product code updated "+pname);
		}
	}
	public void checkQuantity(String pname, String exp_quantity)
	{
		productsearch.sendKeys(pname);
		String act_quantity = quan.getText();
		if(act_quantity.contains(act_quantity))
				{
					System.out.println("quantity not updated");
				}
		else
		{
				System.out.println("quantity updated");
		}
		
	}
	
	
}
