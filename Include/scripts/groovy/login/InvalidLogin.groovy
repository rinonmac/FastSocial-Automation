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



class InvalidLogin {
	@Given("User has invalid user account")
	def given_invalid_creditentials() {
		println("Invalid User")
	}

	@When("User is typing invalid (.*) and (.*) on login form")
	def input_wrong_username_and_password(String username, String password) {
		WebUI.click(findTestObject('Object Repository/Login Page/acceptCookies'))
		println("Typing : " +username)
		WebUI.setText(findTestObject('Object Repository/Login Page/usernameForm'), username)
		println("Typing : " +password)
		WebUI.setText(findTestObject('Object Repository/Login Page/passwordForm'), password)
		println("Uncheck remember device")
		WebUI.click(findTestObject('Object Repository/Login Page/rememberCheck'))
	}

	@Then("Display error (.*)")
	def display_error(String message) {
		WebUI.verifyElementText(findTestObject('Object Repository/Login Page/failedLogin'), message)
		println ("Displayed error message : " +message)
		WebUI.takeScreenshot('Screenshots/InvalidLogin.png')
	}
}