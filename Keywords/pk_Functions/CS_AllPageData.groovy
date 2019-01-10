package pk_Functions
/* Created By Asmaa Elsayed Ibrahim
 * Date 25/12/2018
 * Usage: Setting data existing in data excel sheet according to it's type (txt,lov-select-tag,lov-ul-tag) into corresponding object exist in objects excel 
 *        file/sheet with the same order that exists by calling AllPageObjectFun function 
 * Input: This Function takes only three inputs 
 *  1- File name  2- Sheet name  3- Data as variable using binding  
 * Output : There isn't output 
 */

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.lang.model.element.VariableElement
import login_object.loginObject.*
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.ExcelData

public class CS_AllPageData {

	// Setting data existing in excel sheet of data into all objects existing in certain excel sheet
	//   and certain sheet name that stored in list by calling  AllPageObjectFun function
	@Keyword
	AllPageDataFun (  String fileName , String sheetName , List<TestObject> fieldsData ){

		//getting all objects that stored in list by calling AllPageObjectFun function
		List<TestObject> listObject = new ArrayList<TestObject>((new pk_Functions.CS_AllPageObject()).AllPageObjectFun (fileName , sheetName ))
		int column

		ExcelData  data = findTestData(fileName)
		data.changeSheet( sheetName)

		//loop for setting data into list object that stored in list using AllPageObjectFun function
		for (column = 1; column <= listObject.size(); column++) {
			//if type equals text
			if (data.getValue(2, column)=="txt"){
				//set data of text into corresponding object
				WebUI.setText(listObject[(column - 1)], fieldsData[(column-1)])
				//if type equals LOV by select tag
			}else if (data.getValue(2, column)=="lov-select-tag"){
				//select by label
				WebUI.selectOptionByLabel(listObject[(column - 1)],fieldsData[(column-1)], false)
				//if type equals LOV by UL tag
			}else if (data.getValue(2, column)=="lov-ul-tag"){
				// get value of attribute which indicating the value of X-path for drop down Object and Container Object separating by "&&&"
				String string =data.getValue(4 , column)
				String[] parts = string.split("&&&")
				String part1 = parts[0]
				String part2 = parts[1]
				(new pk_Functions.CS_StaticListUsingLiTag()).LovSearchFun (part1 , part2 ,fieldsData[(column-1)] )

			}
		}
	}
}

