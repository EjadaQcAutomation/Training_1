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

'Click on main tab\r\n'
WebUI.click(findTestObject('IPO/Side Menu/System Setup_Tab'))

'Select screen\r\n'
WebUI.click(findTestObject('IPO/Side Menu/Receiver Channels'))

'Click on Insert button\r\n'
WebUI.click(findTestObject('IPO/Receiver_Channels/Receiver/BTN_Insert'))

'Fill all text fields with data \r\n'
CustomKeywords.'pk_Functions.CS_AllPageData.AllPageDataFun'('Receiver_ObjectRepository', 'Sheet1', [arabic name, fax, mobile
        , telephone, email, name, short name, english name, receiver id])

WebUI.check(findTestObject('IPO/Receiver_Channels/Receiver/RDBTN_Receiver Type_1'))

WebUI.click(findTestObject('IPO/Receiver_Channels/Receiver/BTN_Save'))

