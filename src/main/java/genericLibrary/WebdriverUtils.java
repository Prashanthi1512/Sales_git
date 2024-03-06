package genericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.*;
import org.apache.commons.io.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebdriverUtils {
	/**
	 * Used for implicit wait,page to load
	 * @param driver
	 * @param sec
	 */
	public void waitforPageload(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	/**
	 * To maximize window
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * To minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 *  to create webdriver object
	 * @param driver
	 * @param sec
	 * @return
	 */
	public WebDriverWait webdriverwaitobj(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	/**
	 * webdriver wait, visibility of element
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void elementtoVisible(WebDriver driver,int sec, WebElement ele)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * webdriver wait, element to be clickable
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void elementTobeCliclable(WebDriver driver,int sec,WebElement ele)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.elementToBeClickable(ele));
	}
	/**
	 * webdriver wait, alert is present
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void alertIsPresent(WebDriver driver,int sec)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * webdriver wait, element to be selected
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void elementtobeSelected(WebDriver driver,int sec, WebElement ele)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.elementToBeSelected(ele));
	}
	/**
	 * webdriver wait, Frame to be available
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void frameAvailabeSwitch(WebDriver driver,int sec,WebElement ele)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}
	/**
	 * webdriver wait, title contains
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void titlecontains(WebDriver driver,int sec, String title)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	/**
	 * webdriver wait, url contains
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void urlcontains(WebDriver driver,int sec,String url)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.urlContains(url));	
	}
	/**
	 * select class obj
	 * @param ele
	 * @return
	 */
	public Select dropdownobj(WebElement ele)
	{
		Select sel=new Select(ele);
		return sel;
	}
	/** 
	 * select by index
	 * @param ele
	 * @param index
	 */
	
	public void selectDropdown(WebElement ele,int index)
	{
		dropdownobj(ele).selectByIndex(index);
	}
	/**
	 * select by value
	 * @param ele
	 * @param value
	 */
	public void selectDropdown(WebElement ele,String value)
	{
		dropdownobj(ele).selectByValue(value);
	}
	/**
	 * select by visible text
	 * @param text
	 * @param ele
	 */
	public void selectDropdown(String text,WebElement ele)
	{
		dropdownobj(ele).selectByVisibleText(text);
	}
	/**
	 * deselect by index
	 * @param index
	 * @param ele
	 */
	public void deselect(int index,WebElement ele)
	{
		dropdownobj(ele).deselectByIndex(index);
	}
	/**
	 * deselect by value
	 * @param ele
	 * @param value
	 */
	public void deselectDropdown(WebElement ele,String value)
	{
		dropdownobj(ele).deselectByValue(value);
	}
	/**
	 * deselect by visible text
	 * @param text
	 * @param ele
	 */
	public void deselectDropdown(String text,WebElement ele)
	{
		dropdownobj(ele).selectByVisibleText(text);
	}
	/**
	 * deselect all
	 * @param ele
	 */
	public void deselectdropdown(WebElement ele)
	{
		dropdownobj(ele).deselectAll();
	}
	/**
	 * To get all selected options
	 * @param ele
	 * @return
	 */
	public List<WebElement> getselectedOptionsdd(WebElement ele)
	{
		List<WebElement> options = dropdownobj(ele).getAllSelectedOptions();
		return options;
	}
	/**
	 * To get all options
	 * @param ele
	 * @return
	 */
	public List<WebElement> getalloptions(WebElement ele)
	{
		List<WebElement> options = dropdownobj(ele).getOptions();
		return options;
	}
	/**
	 * Actions class obj
	 * @param driver
	 * @return
	 */
	
	public Actions actionobj(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	/**
	 * Mousehover actions
	 * @param driver
	 * @param ele
	 */
	
	public void mousehover(WebDriver driver,WebElement ele)
	{
		actionobj(driver).moveToElement(ele).click().perform();
	}
	
	
	public void clickMovebyOffset(WebDriver driver,int x,int y)
	{
		actionobj(driver).doubleClick().click().moveByOffset(x, y).perform();
	}
	
	/**
	 * double click
	 * @param driver
	 * @param ele
	 */
	public void doubleclick(WebDriver driver,WebElement ele)
	{
		actionobj(driver).doubleClick(ele).perform();
	}
	/** right click
	 * @author Dell
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver,WebElement ele)
	{
		actionobj(driver).contextClick(ele).click().perform();
	}
	/** enter key press
	 * @author Dell
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		actionobj(driver).sendKeys(Keys.ENTER).perform();
	}
	/**
	 * Robot class obj
	 * @return
	 * @throws AWTException
	 */
	public Robot robotobj() throws AWTException
	{
		Robot r=new Robot();
		return r;
	}
	/** key press
	 * @author Dell
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable
	{
		robotobj().keyPress(KeyEvent.VK_ENTER);
		
	}
	/** key release
	 * @author Dell
	 * @throws Throwable
	 */
	
	public void enterrelease() throws Throwable
	{
		
		robotobj().keyRelease(KeyEvent.VK_ENTER);
	}
	/**Switch to frame by index
	 * @author Dell
	 * @param driver
	 * @param index
	 */
	public void switchtoFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**Switch to frame by name
	 * @author Dell
	 * @param driver
	 * @param index
	 */
	public void switchtoFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	/**Switch to frame by address
	 * @author Dell
	 * @param driver
	 * @param index
	 */
	public void switchtoFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/** Alert popup accept
	 * @author Dell
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/** alert popup dismiss
	 * @author Dell
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/** Switch to window
	 * @author Dell
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> windows = driver.getWindowHandles();
		//step2: iterate thru the windows
		Iterator<String> it = windows.iterator();
		//step3: check whether there is next window
		while(it.hasNext())
		{
			String winid = it.next();
			
			//step5: switch to current window and capture title
			String act_title = driver.switchTo().window(winid).getTitle();
			if(act_title.contains(act_title))
			{
				break;
			}
		}
				
	}
	/**
	 * To get screenshot
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public static String screenshot(WebDriver driver,String screenshotname) throws IOException
	{
		JavaUtils jlib=new JavaUtils();
		String Fscriptname = screenshotname+jlib.getSysDateformat();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+Fscriptname+".png";
		File dst=new File(path);
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	/** javascriptexe to scroll
	 * 
	 * 
	 * @author Dell
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	/** javascriptexe to scroll to particular element
	 * @author Dell
	 * @param driver
	 */
	public void scrollAction(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = ele.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",ele);
		//js.executescript("argument[0].scrollIntoView()",ele);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
