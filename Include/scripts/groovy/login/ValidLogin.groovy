package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class ValidLogin {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User is on login page")
	def openbrowser() {
		WebUI.openBrowser(null)
		WebUI.setViewPortSize(1600, 900)
		WebUI.navigateToUrl(GlobalVariable.url)
	}

	@When("User is typing (.*) and (.*) on login form")
	def type_username(String username, String password) {
		WebUI.click(findTestObject('Object Repository/Login Page/acceptCookies'))
		WebUI.setText(findTestObject('Login Page/usernameForm'), GlobalVariable.username)
		println ("Username : " +username)
		//		WebUI.setText(findTestObject('Login Page/usernameForm'), username)
		//		WebUI.delay(2)
		println("Password : " +password)
		//		WebUI.setText(findTestObject('Object Repository/Login Page/passwordForm'), password)
		WebUI.setText(findTestObject('Object Repository/Login Page/passwordForm'), GlobalVariable.password)
		//		WebUI.delay(2);
		WebUI.uncheck(findTestObject('Object Repository/Login Page/rememberCheck'))
		//		WebUI.delay(2)
	}
	//	def type_password(String password) {
	//		WebUI.setEncryptedText(findTestObject('Object Repository/Login Page/passwordForm'), GlobalVariable.password)
	//		println("Password : " +password)
	//		WebUI.setEncryptedText(findTestObject('Object Repository/Login Page/passwordForm'), password)
	//		WebUI.delay(2);
	//	}
	//	def untick_remember_device() {
	//		WebUI.uncheck(findTestObject('Object Repository/Login Page/rememberCheck'))
	//		WebUI.delay(2)
	//	}

	@And("User click login")
	def click_login() {
		WebUI.click(findTestObject('Object Repository/Login Page/loginButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/Login Page/successLogin'), "Selamat datang kembali!")
	}

	@Then("Redirect to homepage")
	def success_login() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Home Page/profileTab'), 0)
		WebUI.takeScreenshot('Screenshots/validLogin.png')
		WebUI.closeBrowser()
	}
}