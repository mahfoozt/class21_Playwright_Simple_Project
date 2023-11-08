package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Key_Down_htmlpage {

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
		
		page.navigate("file:///C:/Java/html-form-page.html");
		Thread.sleep(1000);
		page.locator("#input__text").click();
		Thread.sleep(1000);
		page.locator("#input__text").fill("mahfooz");
		Thread.sleep(1000);
		page.locator("#input__password").click();
		Thread.sleep(1000);
		page.locator("#input__password").fill("1234@56");
		Thread.sleep(1000);
		page.locator("//input[@id='input__webaddress']").fill("https://github.com/mahfoozt/");
		Thread.sleep(1000);
		page.locator("//input[@id='input__emailaddress']").fill("mahfooz.murshalin@gmail.com");
		Thread.sleep(1000);
		page.locator("//input[@id='input__phone']").fill("480-234-5678");
		Thread.sleep(1000);
		page.locator("//input[@id='input__search']").fill("Flower");
		Thread.sleep(2000);
		page.locator("//input[@id='input__text2']").fill("2");
		Thread.sleep(1000);
		//page.locator("//input[@id='input__file']").setInputFiles(Paths.get("./src/test/resources/files/rosylogo.png"));
		page.setInputFiles("//input[@id='input__file']", Paths.get("./src/test/resources/files/rosylogo.png"));
		Thread.sleep(1000);
		page.locator("//select[@id='select']").click();
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./src/test/resources/files/PicKeyDown.png")));
		SelectOption sp;
		sp = new SelectOption();
		page.selectOption("Select", sp.setLabel("Option Two"));
		//page.locator("//input[@id='checkbox1']").click();
		Thread.sleep(2000);
		Locator checkbox = page.locator("[type='checkbox']");
		for(int i=1; i<checkbox.count(); i++) {
			checkbox.nth(i).click();
		}
		//page.locator("//input[@id='checkbox3']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='radio3']").click();
		Thread.sleep(2000);
		page.locator("//textarea[@id='textarea']").click();
		Thread.sleep(1000);
		page.locator("//textarea[@id='textarea']").click();
		Thread.sleep(2000);
		page.locator("//textarea[@id='textarea']")
				.fill("Hello everyone, this is Mahfooz. I am working as an intern at Michro Tech.");
		Thread.sleep(1000);
		page.locator("//input[@id='ic']").click();
		Thread.sleep(5000);
		//page.locator("//input[@id='ic']").fill("#00FF00");
		page.locator("//input[@id='in']").click();
		Thread.sleep(2000);
		page.locator("//input[@id='in']").fill("7");
		Thread.sleep(2000);
		page.locator("//input[@id='ir']").click();
		Thread.sleep(2000);
		page.locator("//input[@id='ir']").click();
		Thread.sleep(2000);
		page.locator("//input[@id='idd']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='idd']").fill("2023-11-06");
		Thread.sleep(1000);
		page.locator("//input[@id='idm']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='idm']").fill("2023-11");
		Thread.sleep(1000);
		page.locator("//input[@id='idw']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='idw']").fill("2023-W01");
		Thread.sleep(1000);
		page.locator("//input[@id='idt']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='idt']").fill("2023-11-06T00:00:00Z");
		Thread.sleep(1000);
		page.locator("//input[@id='idtl']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='idtl']").fill("2023-11-06T00:00");
		Thread.sleep(1000);
		page.locator("//input[@id='idl']").click();
		Thread.sleep(3000);
		//page.locator("//input[@type='submit'][1]").click();
		//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./src/test/resources/files/PicKeyDown.png")));
//		Thread.sleep(3000);
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
		//page.locator("//*[@id='idl']").hover();
		//page.locator("//*[@id='example-list']/option[3]").click();
//		page.close();
//		browser.close();
//		playwright.close();
		
	}

}
