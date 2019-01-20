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

CustomKeywords.'pk_Functions.CS_StaticListUsingLiTag.LovSearchIndexFun'('//*[@id="menu_admin_viewAdminModule"]', '//*[@id="wrapper"]/div[2]/ul/li[1]/ul/li/a', 
    6)

CustomKeywords.'pk_Functions.CS_StaticListUsingLiTag.LovSearchIndexFun'('//*[@id="menu_admin_Configuration"]', '//*[@id="wrapper"]/div[2]/ul/li[1]/ul/li[6]/ul/li/a', 
    1)

WebUI.delay(4)

//CustomKeywords.'pk_Functions.CS_SpecificPageData.DataFun'(['edit', 'sendmethod','sendas','host', 'port'], 'TestKeywords/Orange_EmailConfigurationObjectComponent', 'Sheet1', [edit,sendmethod, sendas,host, port ])
CustomKeywords.'pk_Functions.CS_AllPageData.AllPageDataFun'('TestKeywords/Orange_EmailConfigurationObjectComponent', 'Sheet1', 
    [edit, sendas, sendmethod, host, port, Authentication, user, password, testemail, connection, emailaddress, save])

