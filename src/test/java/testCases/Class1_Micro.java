package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class1_Micro {

	public static void main(String[] args) throws InterruptedException {
		String chromePath="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		//playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();
			
		Browser browser;
		browser =playwright.chromium().launch(new BrowserType
		.LaunchOptions()
		.setHeadless(false)
		.setExecutablePath(Paths.get(chromePath)));
		
		Page page;
		page = browser.newPage(); 
		//page.navigate("https://github.com/mahfoozt");
		page.navigate("https://it.microtechlimited.com");
		
		System.out.println( page.title() );
		Thread.sleep(2000);

		page.locator("text=LOG IN").click();
		Thread.sleep(2000);
		page.locator("//input[@name='mailuid']").fill("testpilot@gmail.com");
		Thread.sleep(1000);
		page.locator("//input[@name='pwd']").fill("1234");
		Thread.sleep(1000);
		page.locator("//input[@name='login-submit']").click();
		Thread.sleep(1000);
		System.out.println( page.title() );
		Thread.sleep(1000);
		page.goBack();
		Thread.sleep(1000);
		page.locator("//a[text()='Customer Login']").click();
		Thread.sleep(1000);
		page.locator("//input[@name='mailuid']").fill("david@gmail.com");
		Thread.sleep(1000);
		page.locator("//input[@name='pwd']").fill("1234");
		Thread.sleep(1000);
		page.locator("//input[@name='login-submit']").click();
		System.out.println( page.title() );
		Thread.sleep(1000);
		page.goBack();
		Thread.sleep(1000);
		page.locator("//a[text()='HOME']").click();
		Thread.sleep(1000);
		page.locator("//a[text()='CONTACT']").click();
	
		//page.close();
		//browser.close();
		//playwright.close();
		// Absolute xPath = /html/body/div[2]/form/input[1]
		// relative xPath = //input[name="mailuid"]
		
	}	

}
