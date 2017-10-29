package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	public static Logger log=Logger.getLogger(Scenario_Search.class);
	
	@Test(dataProvider="dp_Invalidsearch",dataProviderClass=DataProvider_Component.Testdatadataprovider.class,groups={"smoke"})
	public void testInvalidSearch(Map<String,String> Search) throws InterruptedException, IOException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result");
		
		Start_Server();
		Launch_app();
		
		log.info("Executing the Testcase  "+TC_ID + " Order set is  "+Order_Set);
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		
		Explicit_Wait(BS_Pob.Search_txtbox, 25);		
		BS_Pob.EnterSearch(Search_Item);
		
		Explicit_Wait(BS_Pob.Invalid_msg, 25);
		String Actual_Result = BS_Pob.getInvalidmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is " +Actual_Result + " matching with Expected Result "+Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is " +Actual_Result + " NOT matching with Expected Result "+Exp_Result);
			sAssert.fail("Failed as Actual Result is " +Actual_Result + " NOT matching with Expected Result "+Exp_Result);
		}
		
		Stop_Server();
		sAssert.assertAll();
		
	}
	
	
	
	@Test(dataProvider="dp_Validsearch", dataProviderClass=DataProvider_Component.Testdatadataprovider.class,groups={"regression"})
	public void testValidSearch(Map<String,String> Search) throws InterruptedException, IOException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result").replace(".0", "");
		
		Start_Server();
		Launch_app();
		
		log.info("Executing the Testcase "+TC_ID + " Order Set is "+Order_Set);
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_Wait(BS_Pob.Search_txtbox, 25);		
		BS_Pob.EnterSearch(Search_Item);
		
		Explicit_Wait(BS_Pob.Valid_msg, 25);
		 String Output = BS_Pob.getValidmsg();
		 
		 String Actual_Result = Output.replace(" Items", "");
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result +" Expected Result is "+Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is "+Actual_Result +" Expected Result is "+Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result +" Expected Result is "+Exp_Result);
		}
		
		
		
		Stop_Server();	
		sAssert.assertAll();
		
		
		
	}
	
	
	

}
