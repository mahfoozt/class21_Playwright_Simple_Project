package testCaes_AUI;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Selectable {

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
		page.navigate("https://jqueryui.com/Selectable");		
		System.out.println(page.title());
		Thread.sleep(2000);
		// Navigate to a page with an iframe
		//page.locator("//a[text()='Selectable']").click();
		//switching to frame
		//page.frame("//iframe");
		Thread.sleep(2000);
		//page.frameLocator("//iframe");
		//page.locator("//iframe[@class='demo-frame']").click();
		//click the item numbers inside the iframe
		page.locator("//ol[@id='selectable']/li[1]").click();
		//page.locator("").click();
		//"./Snap_AUI_Concept/TAB_ENTER_image.png"
		
		
//		page.close();
//		browser.close();
//		playwright.close();
		
		

	}

}
