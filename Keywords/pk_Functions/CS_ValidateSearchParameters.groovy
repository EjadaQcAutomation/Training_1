package pk_Functions
/* Created By ‘Ebtehal Gamal Yusuf and Asmaa El-Sayed’
 * Date 13/01/2019
 * Usage:This Function is used to compare record in grid with expected result it can be used to validate that search parameters filters data 
 * Input:There are four inputs required for this function (Webtable id ,List of Expected Values and First Expected Value locator) 
 * Output:Ensure thst record is matched with expected record or not 
 */
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
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
@Keyword
//Setting keyword inputs
ValidateSearchParameters (String webtableId , List ExpectedValues = [], int uniqueColumn ) {

	List<String> Columns_row_text  = new ArrayList<String>()
	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> Columns_row

	//To locate table
	WebElement Table = driver.findElement(By.id(webtableId))

	//To locate rows of table it will Capture all the rows available in the table
	List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
	//To calculate no of rows In table'
	int rows_count = rows_table.size()
	//Loop will execute for all the rows of the table
	Loop:
	for (int row = 1; row < rows_count; row++) {
		//To locate columns(cells) of that specific row'
		Columns_row = rows_table.get(row).findElements(By.tagName('td'))


		//To calculate no of columns(cells) In that specific row
		int columns_count = Columns_row.size()

		//println((('Number of cells In Row ' + row) + ' are ') + columns_count)


		//Checking if firstCell text is matched with the expected value
		if (Columns_row.get(uniqueColumn).getText() == ExpectedValues[uniqueColumn]) {
			for (int column = 0 ; column < columns_count ;column++){
				Columns_row_text.add(Columns_row.get(column).getText())

			}
			break
		}
	}
	//Compare the actual record with expected record data inserted as inputs to the keyword
	assert Columns_row_text == ExpectedValues
}


