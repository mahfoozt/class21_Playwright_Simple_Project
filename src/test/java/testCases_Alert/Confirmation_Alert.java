package testCases_Alert;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Confirmation_Alert {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));
		Page page;
		page = browser.newPage();

		page.navigate("https://the-internet.herokuapp.com");
		Thread.sleep(2000);
		page.locator("//a[text()='JavaScript Alerts']").click();
		Thread.sleep(2000);
		page.locator("//button[text()='Click for JS Confirm']").click();
		Thread.sleep(2000);
//		page.goBack();
//		Thread.sleep(2000);
//		page.locator("//a[text()='Dropdown']").click();
//		Thread.sleep(2000);
//		page.locator("//select[@id='dropdown']").click();
//		Thread.sleep(2000);
//		//page.locator("//select[@id='dropdown']/option[2]").click();
		/*
		 * page.navigate("file:///C:/java/html-form-page.html");
		 * 
		 * //Selector is either xPath or CSS-Selectors
		 * page.locator("//input[@id='input__text']").fill("Dallas");
		 * Thread.sleep(3000);
		 * 
		 * SelectOption sp; sp = new SelectOption();
		 * 
		 * //page.selectOption ("select", sp.setLabel("Option Three"));
		 * page.selectOption ("select", sp.setIndex(0));
		 * 
		 * Thread.sleep(3000); page.locator("//input[@id='checkbox1']").click();
		 * //toggle page.locator("//input[@id='checkbox2']").click();
		 * 
		 * Thread.sleep(3000); page.locator("//input[@id='radio3']").click();
		 * 
		 * Thread.sleep(3000); page.locator("//input[@id='idd']").fill("2023-10-23");
		 * //page.locator("//input[@id='idd']").fill("02");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * page.selectOption ("//datalist[@id='example-list']",
		 * sp.setValue("Example #2")); //page.selectOption ("select", sp.setIndex(0));
		 * 
		 * 
		 * //page.locator("//select[@id='select']").click();
		 * //page.locator("//select[@id='select']/optgroup/option[text()='Option Two']")
		 * .click();
		 * 
		 * 
		 */

		// page.close();
		// browser.close();
		// playwright.close();

	}

}
