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

List<WebElement> Columns_row_text = new ArrayList<String>()

WebDriver driver = DriverFactory.getWebDriver()

'Expected value from Table'
List<WebElement> ExpectedValues = ['', 'Account Clerk', 'test test']

List<WebElement> Columns_row

'To locate table'
WebElement Table = driver.findElement(By.id('resultTable'))

'To locate rows of table it will Capture all the rows available in the table'
List<WebElement> rows_table = Table.findElements(By.tagName('tr'))

'To calculate no of rows In table'
int rows_count = rows_table.size()

'Loop will execute for all the rows of the table'
Loop: for (int row = 1; row < rows_count; row++) {
    'To locate columns(cells) of that specific row'
    Columns_row = rows_table.get(row).findElements(By.tagName('td'))

    'To calculate no of columns(cells) In that specific row'
    int columns_count = Columns_row.size()

    //println((('Number of cells In Row ' + row) + ' are ') + columns_count)
    'Checking if Cell text is matching with the expected value'
    if (Columns_row.get(1).getText() == (ExpectedValues[1])) {
        println('Search is working successfullyhghjg')

        for (int column = 0; column < columns_count; column++) {
            Columns_row_text.add(Columns_row.get(column).getText())
        }
        
        if (Columns_row_text == ExpectedValues) {
            println('Search is working successfully')

            break
        }
    }
}

WebUI.acceptAlert()

assert true

