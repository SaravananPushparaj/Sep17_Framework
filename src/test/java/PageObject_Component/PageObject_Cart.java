package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Cart {
	
	//2nd section
	@FindBy(id="com.bigbasket.mobileapp:id/btnAddToBasket")
	public WebElement Add_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/cartcountView")
	public WebElement Cart_img;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement AddCart_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Remove_btn;
	

	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_msg;
	
	
	
	//1st section
	
	public PageObject_Cart(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Reusable methods
	
	public void Click_Add()
	{
		Add_btn.click();
	}
	
	public void Click_Img()
	{
		Cart_img.click();
	}
	
	public String getAddCartmsg()
	{
		return AddCart_msg.getText();
		
	}
	
	public void Click_Remove()
	{
		Remove_btn.click();
	}
	
	public String getDeleteCartmsg()
	{
		return Delete_msg.getText();
		
	}
	
	
	
	
	

}
