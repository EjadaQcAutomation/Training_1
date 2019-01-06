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



'Expected value from Table'
String ExpectedValue = 'Sales Executive'

WebDriver ndriver = DriverFactory.getWebDriver()

'To locate table'
WebElement Table = ndriver.findElement(By.id('resultTable'))

'To locate rows of table it will Capture all the rows available in the table '
List<WebElement> Rows = Table.findElements(By.tagName('tr'))

println('No. of rows: ' + Rows.size())

'Find a matching text in a table and performing action'

'Loop will execute for all the rows of the table'
table: for (int i = 1; i < Rows.size(); i++) {
    'To locate columns(cells) of that specific row'
    List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

	println('No. of colns: ' + Cols.size())
   // for (int j = 0; j < Cols.size(); j++) {
        'Verifying the expected text in the each cell'
        if (Cols.get(1).getText().equalsIgnoreCase(ExpectedValue)) {
            'To locate anchor in the expected value matched row to perform action'
            //Cols.get(4).findElement(By.tagName('a')).click()
			
			Cols.get(1).findElement(By.tagName('a')).click() ;
			
           break
       }
   // }
}

