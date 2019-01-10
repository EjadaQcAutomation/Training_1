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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(findTestObject('Orange/Navigation/MNULST_Admin'))

WebUI.click(findTestObject('Orange/Navigation/MNUITM_Job'))

WebUI.click(findTestObject('Orange/Navigation/MNUITM_JobTitles'))

'Add New Record\r\n'
WebUI.click(findTestObject('Orange/JobTitles/BTN_Add'))

'Data Entry'
CustomKeywords.'pk_Functions.CS_AllPageData.AllPageDataFun'('Orange_JobTitles_ObjectRepository', 'Sheet1', [jobtitles, jobdescription
        , notes])

WebUI.delay(1)

// Custom Keyword used because 'Upload File' or 'Send keys' won't work for this test case
CustomKeywords.'tools.CS_UploadFiles.uploadFile'(findTestObject('Orange/JobTitles/BTN_ChooseFile'), '"D:\\Ebtehal_QC\\Extras\\logo.jpg"')

Thread.sleep(2000 //2500, 3000, other might work for you
    )

WebUI.click(findTestObject('Orange/JobTitles/BTN_Save'))

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Orange/JobTitles/MSG_SuccessValidationMessage'), 0)

WebUI.delay(2)

CustomKeywords.'pk_Functions.CS_SelectRecordFromWebtable.SelectRecordFromWebtableFun'('resultTable', 'Qc Engineer_Ebtehal', 
    1, 1)

