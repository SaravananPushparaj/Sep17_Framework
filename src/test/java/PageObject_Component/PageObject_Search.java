package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	//2nd section
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Search_txtbox;	
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_txtbox2;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_msg;
	
	
	//1st section
	
	public PageObject_Search(AppiumDriver driver)	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//3rd section
	
	public void EnterSearch(String Search_Item)
	{
		Search_txtbox.click();
		Search_txtbox2.sendKeys(Search_Item +"\n");
		
	}
	
	
	public String getInvalidmsg()
	{
		return Invalid_msg.getText();
		
	}
	
	
	public String getValidmsg()
	{
		return Valid_msg.getText();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
