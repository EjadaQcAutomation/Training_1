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

CustomKeywords.'pk_Functions.CS_Login.LoginFun'(findTestObject(null), 'https://opensource-demo.orangehrmlive.com/index.php/auth/login', 
    findTestObject('Orange/Login/Username'), findTestObject('Orange/Login/Password'), 'Admin', 'admin123', findTestObject(
        'Orange/Login/Login'))

WebUI.click(findTestObject('Orange/Navigation/MNUITM_Recruitment'))

CustomKeywords.'pk_Functions.CS_TextLov.TextLovFun'('TestKeywords/AllObjectComponent', 'Sheet1', [CandidateName, JobTitle
        , WelcomeAdmin])

