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

CustomKeywords.'pk_Functions.CS_SpecificPageData.DataFun'(['username', 'password'], 'TestKeywords/Object', 'Sheet1', [username
        , password])

WebUI.click(findTestObject('Orange/Login/Login'))

CustomKeywords.'pk_Functions.CS_StaticListUsingLiTag.LovMatchItemsFun'('//*[@id="menu_admin_viewAdminModule"]/b', '//*[@id="wrapper"]/div[2]/ul/li[1]/ul/li', 
    ['User Management', 'Job', 'Organization', 'Qualifications', 'Nationalities', 'Configuration'])

CustomKeywords.'pk_Functions.CS_StaticListUsingLiTag.LovSearchFun'('//*[@id="menu_admin_Job"]', '//*[@id="wrapper"]/div[2]/ul/li[1]/ul/li[2]/ul/li', 
    'Job Titles')

