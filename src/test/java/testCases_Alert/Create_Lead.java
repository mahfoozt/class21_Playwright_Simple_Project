package testCases_Alert;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Create_Lead {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		//playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));
		
		Page page;
		page = browser.newPage();
		
		page.navigate("http://leaftaps.com/opentaps");
		//Get page title
		System.out.println(page.title());
		Thread.sleep(2000);
		//Enter user name
		page.locator("//input[@id='username']").fill("DemoSalesManager");
		Thread.sleep(2000);
		//Enter password name
		page.locator("//input[@id='password']").fill("crmsfa");
		//click login button
		page.locator("//input[@class='decorativeSubmit']").click();
		Thread.sleep(3000);
		//Click CRMSFA
		page.locator("text=CRM/SFA").click();
		Thread.sleep(2000);
		//click create lead
		Thread.sleep(2000);
		page.locator("//a[text()='Create Lead']").click();
		Thread.sleep(2000);
		//Enter company name
		page.locator("//input[@id='createLeadForm_companyName']").fill("CTS");
		Thread.sleep(2000);
		//Enter First name
		page.locator("//input[@id='createLeadForm_firstName']").fill("Hema");
		Thread.sleep(2000);
		//Enter Last name
		page.locator("//input[@id='createLeadForm_lastName']").fill("Mali");
		Thread.sleep(2000);
		//Enter  name
		
		

	}

}
