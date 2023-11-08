package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class4_Html_allTags {

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
		
		page.navigate("file:///C:/Java/html-all-tags-v1.html");
		Thread.sleep(3000);
		page.locator("//a[text()='Headings']").click();
		Thread.sleep(3000);
		page.goBack();
		page.locator("//a[text()='Address']").click();
		Thread.sleep(3000);
		page.locator("//a[text()='Paragraphs']").click();
		Thread.sleep(3000);
		page.goBack();
		Thread.sleep(3000);
		page.locator("//a[text()='Lists']").click();
		Thread.sleep(3000);
		page.goBack();
		Thread.sleep(3000);
		page.locator("//a[text()='Blockquotes']").click();
		Thread.sleep(3000);
		page.goBack();
		Thread.sleep(3000);
		page.locator("//a[text()='Embedded content']").click();
		

	}

}
