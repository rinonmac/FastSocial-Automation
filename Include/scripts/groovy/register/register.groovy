package register
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



class register {
	@Given("User is on register page")
	def open_website() {
		WebUI.openBrowser(null)
		WebUI.setViewPortSize(1600, 900)
		WebUI.navigateToUrl(GlobalVariable.url)
		println("Opened Fast Social Website")
	}

	@Given("User want to register account")
	def open_register_page() {
		WebUI.click(findTestObject('Object Repository/Register Page/daftarBtn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Global/header'), 1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Global/subHeader'), 1)
		WebUI.verifyElementText(findTestObject('Object Repository/Global/header'), "Daftar")
		WebUI.verifyElementText(findTestObject('Object Repository/Global/subHeader'), "Buat Akun Fast Social Anda!")
		println("Opened Register Page")
	}

	@When("User typing (.*) , (.*) , (.*) , (.*) , (.*) , and (.*)")
	def type_register_form(String firstname, String lastname, String email, String password, String gender) {
		WebUI.setText(findTestObject('Object Repository/Register Page/firstNameForm'), firstname)
		println("Inputted : " +firstname)
		WebUI.setText(findTestObject('Object Repository/Register Page/lastnNameForm'), lastname)
		println("Inputted : " +lastname)
		WebUI.setText(findTestObject('Object Repository/Register Page/emailForm'), email)
		println("Inputted : " +email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Login Page/passwordForm'), password)
		println("Inputted : " +password)
		WebUI.setEncryptedText(findTestObject('Object Repository/Register Page/confrimPasswordForm'), password)
		println("Inputted : " +password)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Register Page/genderForm'), 1)
		println("Selected : " +gender)
		WebUI.check(findTestObject('Object Repository/Register Page/acceptTermsCheck'))
		WebUI.verifyElementChecked(findTestObject('Object Repository/Register Page/acceptTermsCheck'), 1)
		println("Accepted Terms")
		WebUI.click(findTestObject('Object Repository/Register Page/registerButton'))
		println("Clicked Register Button")
	}

	@Then("Display Success Message")
	def verify_message() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Register Page/alertSuccess'), 1)
		WebUI.verifyElementText(findTestObject('Object Repository/Register Page/alertSuccess'), "Registrasi berhasil! Kami telah mengirimkan email kepada Anda, Silakan periksa kotak masuk/spam Anda untuk memverifikasi email Anda.")
		WebUI.takeScreenshot('Screenshots/successRegister.png')
	}
}