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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.demoblaze.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/UserOnboard/a_Log in'))

WebUI.setText(findTestObject('Object Repository/UserOnboard/input_Username_loginusername'), 'boosstt')

WebUI.setText(findTestObject('Object Repository/UserOnboard/input_Password_loginpassword'), 'testt')

WebUI.click(findTestObject('Object Repository/UserOnboard/button_Log in'))

WebUI.verifyAlertPresent(3)

'Get text alert on the alert when it\'s shown'
alertText = WebUI.getAlertText()

'Verify text alert is correct or not'
WebUI.verifyMatch(alertText, 'User does not exist.', false)

WebUI.closeBrowser()

