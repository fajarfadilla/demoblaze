import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('homepage/Product/RegUser - productDetail - Add to cart - Continue'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/cart/a_Cart'))

WebDriver driver = DriverFactory.getWebDriver()

'Expected value from Table'
String ExpectedValue = 'Pay Talk'

'To locate table'
WebElement Table = driver.findElement(By.xpath('//table/tbody'))

'To locate rows of table it will Capture all the rows available in the table'
List<WebElement> rows_table = Table.findElements(By.tagName('tr'))

'To calculate no of rows In table'
int rows_count = rows_table.size()

int totalPayment = 0

'Loop will execute for all the rows of the table'
Loop: for (int row = 0; row < rows_count; row++) {
    'To locate columns(cells) of that specific row'
    List<WebElement> Columns_row = rows_table.get(row).findElements(By.cssSelector('td:nth-of-type(3)'))

    'To calculate no of columns(cells) In that specific row'
    int columns_count = Columns_row.size()

    for (int column = 0; column < columns_count; column++) {
        String celltext = Columns_row.get(column).getText()

        totalPayment += Integer.parseInt(celltext)
    }
}

println(totalPayment)

'Verifikasi total payment'
WebUI.waitForElementPresent(findTestObject('cart/TotalPayment'), 3)

WebUI.verifyElementText(findTestObject('cart/TotalPayment'), String.valueOf(totalPayment))

WebUI.click(findTestObject('Object Repository/order/button_Place Order'))

WebUI.setText(findTestObject('Object Repository/order/input_Name_name'), 'boosst')

WebUI.setText(findTestObject('Object Repository/order/input_Country_country'), 'INDONESIA')

WebUI.setText(findTestObject('Object Repository/order/input_City_city'), 'JAKARTA')

WebUI.setText(findTestObject('Object Repository/order/input_Credit card_card'), '110378293213')

WebUI.setText(findTestObject('Object Repository/order/input_Month_month'), '12')

WebUI.setText(findTestObject('Object Repository/order/input_Year_year'), '2024')

WebUI.click(findTestObject('Object Repository/order/button_Purchase'))

WebUI.waitForElementPresent(findTestObject('order/h2_Thank you for your purchase'), 3)

WebUI.verifyElementText(findTestObject('order/h2_Thank you for your purchase'), 'Thank you for your purchase!')

WebUI.click(findTestObject('Object Repository/order/button_OK'))

WebUI.closeBrowser()

