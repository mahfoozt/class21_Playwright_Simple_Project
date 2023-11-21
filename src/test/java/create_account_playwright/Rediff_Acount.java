package create_account_playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Rediff_Acount {

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
		
		page.navigate("https://www.rediff.com/");
		//Get page title
		System.out.println(page.title());
		Thread.sleep(2000);
		//Click on Create Account
		page.locator("//a[text()='Create Account']").click();
		Thread.sleep(2000);
		//Enter user name
		page.locator("//input[starts-with(@ name, 'name')]").click();
		page.locator("//input[starts-with(@ name, 'name')]").fill("Mahfooz Murshalin");
		Thread.sleep(2000);
		//Choose a Rediffmail ID
		page.locator("//input[starts-with(@ name, 'login')]").click();
		page.locator("//input[starts-with(@ name, 'login')]").fill("mahfooz.murshalin");
		Thread.sleep(2000);
		//Click on Check availability
		page.locator("//input[starts-with(@ name, 'btnchkavail')]").click();
		Thread.sleep(2000);
		//Enter password 
		page.locator("//input[starts-with(@ name, 'passwd')]").click();
		page.locator("//input[starts-with(@ name, 'passwd')]").fill("1234Rosy");
		Thread.sleep(1000);
		//Retype password 
		page.locator("//input[starts-with(@ name, 'confirm_passwd')]").click();
		page.locator("//input[starts-with(@ name, 'confirm_passwd')]").fill("1234Rosy");
		Thread.sleep(1000);
		//Click Alternate Email Address
		page.locator("//input[starts-with(@ name, 'altemail')]").click();
		page.locator("//input[starts-with(@ name, 'altemail')]").fill("Rosy@gmail.com");
		Thread.sleep(2000);
		page.locator("//input[starts-with(@ name, 'mobno')]").click();
		page.locator("//input[starts-with(@ name, 'mobno')]").fill("4802346090");
		Thread.sleep(2000);
		//Click Date of birth
		page.locator("//select[starts-with(@ name, 'DOB_Day')]").click();
		Thread.sleep(2000);
		page.locator("//select[starts-with(@ name, 'DOB_Month')]").click();
		Thread.sleep(2000);
		page.locator("//select[starts-with(@ name, 'DOB_Year')]").click();
		//click Gender button
		page.locator("//input[starts-with(@ name, 'gender')][2]").click();
		Thread.sleep(2000);
		//Click on Country
		page.locator("//select[starts-with(@ name, 'country')]").click();
		Thread.sleep(2000);
	}

}
