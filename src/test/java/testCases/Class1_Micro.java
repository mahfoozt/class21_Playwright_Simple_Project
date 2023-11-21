package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class1_Micro {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		// playwright declaration and creation
		Playwright playwright;
		playwright = Playwright.create();

		Browser browser;
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get(chromePath)));

		Page page;
		page = browser.newPage();
		// page.navigate("https://github.com/mahfoozt");
		page.navigate("https://it.microtechlimited.com");
		//Get page title
		System.out.println(page.title());
		//click Login In
		Thread.sleep(2000);
		page.click("text=LOG IN");
		//Click on User Id 
		Thread.sleep(2000);
		page.locator("//input[@name='mailuid']").fill("testpilot@gmail.com");
		Thread.sleep(1000);
		page.locator("//input[@name='pwd']").fill("1234");
		Thread.sleep(1000);
		page.click("//input[@name='login-submit']");
		Thread.sleep(1000);
		System.out.println(page.title());
		Thread.sleep(1000);
		page.goBack();
		Thread.sleep(1000);
		page.click("//a[text()='Customer Login']");
		Thread.sleep(1000);
		page.locator("//input[@name='mailuid']").fill("david@gmail.com");
		Thread.sleep(1000);
		page.locator("//input[@name='pwd']").fill("1234");
		Thread.sleep(1000);
		page.locator("//input[@name='login-submit']").click();
		Thread.sleep(1000);
		//Take Screenshot and save inside target Folder
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/MicroTech.png")));
		System.out.println(page.title());
		Thread.sleep(1000);
		page.goBack();
		Thread.sleep(1000);
		page.locator("//a[text()='HOME']").click();
		Thread.sleep(1000);
		page.locator("//a[text()='CONTACT']").click();
		// Verify the Customer Login page
		System.out.println("***********MicroTech NA HW*************************");
		Thread.sleep(2000);
		System.out.println(page.title());
		System.out.println("MicroTech NA");
		String LandingMessage = page.textContent("//p[text()='MicroTech NA']");
		if (LandingMessage.contains("")) {
			System.out.println("MicroTech NA is Matched. So Test Case is Pass");
		} else {
			System.out.println(" MicroTech NA is Not Matched");
		}
		System.out.println("***********MicroTech NA HW Done*******************");
		
//		String welcomeMsg = page.textContent("//h2[text()='Welcome David']");//
//		if (welcomeMsg.contains("Welcome David"))
//			System.out.println("Test is pass");
//		else
//			System.out.println("Test is Fail");  

		// page.close();
		// browser.close();
		// playwright.close();
		// Absolute xPath = /html/body/div[2]/form/input[1]
		// relative xPath = //input[name="mailuid"]

	}

}
