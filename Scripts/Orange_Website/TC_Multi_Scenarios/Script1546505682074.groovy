import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://opensource-demo.orangehrmlive.com/index.php/auth/login')

WebUI.setText(findTestObject('Orange/Login/Username'), 'Admin')

WebUI.setText(findTestObject('Orange/Login/Password'), 'admin123')

WebUI.click(findTestObject('Orange/Login/Login'))

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/index.php/admin/viewLocations')

WebUI.click(findTestObject('Orange/Locations/btn_Add'))

WebUI.selectOptionByValue(findTestObject('Orange/Locations/Lov_country'), 'EG', false)

CustomKeywords.'pk_Functions.CS_AllPageData.AllPageDataFun'('Orange/Location_ObjectRepository', 'Sheet1', [Name, StateProvince
        , City, Address, ZipPostalCode, Phone, Fax, Notes])

WebUI.click(findTestObject('Orange/Locations/btn_Save'))

