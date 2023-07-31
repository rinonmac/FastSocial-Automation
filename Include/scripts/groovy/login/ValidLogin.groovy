package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

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
	@Given("User is on login page")
	def openbrowser() {
		WebUI.openBrowser(null)
		WebUI.setViewPortSize(1600, 900)
		WebUI.navigateToUrl(GlobalVariable.url)
		println("Opened Fast Social Website")
	}

	@Given("User has valid user account")
	def print_username_and_password() {
		println("Username: " +GlobalVariable.username)
		println("Password: " +GlobalVariable.password)
	}

	@When("User is typing valid username and password on login form")
	def type_username_and_password() {
		WebUI.click(findTestObject('Object Repository/Login Page/acceptCookies'))
		WebUI.setText(findTestObject('Login Page/usernameForm'), GlobalVariable.username)
		WebUI.setText(findTestObject('Object Repository/Login Page/passwordForm'), GlobalVariable.password)
		WebUI.click(findTestObject('Object Repository/Login Page/rememberCheck'))
	}
	@And("User click login")
	def click_login() {
		WebUI.click(findTestObject('Object Repository/Login Page/loginButton'))
		println("Clicked login button")
	}

	@Then("Redirect to homepage")
	def success_login() {
		WebUI.verifyElementText(findTestObject('Object Repository/Login Page/successLogin'), "Selamat datang kembali!")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Home Page/profileTab'), 0)
		WebUI.takeScreenshot('Screenshots/validLogin.png')
	}
}