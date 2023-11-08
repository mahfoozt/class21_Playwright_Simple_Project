package testCaes_AUI;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Key_Down {

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
		page.navigate("https://jqueryui.com");		
		System.out.println(page.title());
		Thread.sleep(2000);
//		page.locator("//a[text()='Selectable']").click();
		page.locator("//a[text()='Draggable']").click();
//		page.locator("//a[text()='Selectable']").click();
//		page.locator("//a[text()='Resizable']").click();
//		page.locator("//a[text()='Sortable']").click();
////		Thread.sleep(3000);
//		page.locator("//datalist[@id='example-list']/option[1]").click();
//		Thread.sleep(3000);
//		SelectOption sp1;
//		sp1 = new SelectOption();	
//		page.selectOption("Datalist", sp1.setLabel("Example #2"));
				
		// page.setInputFiles("//input[@id='input__file']", Paths.get("file path"));

		// https://test.skyitschool.com/htmlalltags-v1.html
		// page.navigate("https://jqueryui.com");
		// System.out.println( page.title() );
//		Thread.sleep(2000);
		// click Select able button outside the frame
		// page.locator("//a[text()='Selectable']").click(); 
		
		// Locate the frame by selector or name
		// String frame = page.frame({ name: 'frameName' });

		// Locator locator = page.frameLocator("iframe").getByText("Item1");
		// locator.click();
//		page.close();
//		browser.close();
//		playwright.close();
//		
	}

}
