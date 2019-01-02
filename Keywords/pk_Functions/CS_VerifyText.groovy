package pk_Functions

/*Created By " Asmaa Elsayed Ibrahim
 * Date 25/12/2018
 * Function :	' verify test of message  '
 * Input :  This Function takes inputs 
 * 1- localHost 
 * 2- String port 
 * 3- serverName 
 * 4- username
 * 5- password 
 * 6- Query 
 * 7- object of message
 * Output : there isn't output for this function 
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

import internal.GlobalVariable

public class CS_VerifyText {


	@Keyword
	VerifyTextFun ( String localHost , String port , String serverName , String username, String password , String Query , String object ){

		// call Dbase Function to connect DB and get string of query
		String text =(new pk_Functions.CS_DataBase()).DbaseFun( localHost ,  port ,  serverName ,  username,  password ,  Query)
		println text
		WebUI.verifyElementText(findTestObject(object), text)
	}
}




