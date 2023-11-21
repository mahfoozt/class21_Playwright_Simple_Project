package testCases;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

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
		page.navigate("file:///C:/Java/SDET_Class/html-form-page.html");
		Thread.sleep(1000);
//		ArrayList <String> argument= new ArrayList<>();
//		argument.add("--start-maximized");
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
		//attach file
		Thread.sleep(1000);
		//page.locator("//input[@id='input__file']").click();
		//page.locator("//input[@id='input__file']").setInputFiles(Paths.get("./src/test/resources/files/rosylogo.png"));
		page.setInputFiles("//input[@id='input__file']", Paths.get("./src/test/resources/files/rosylogo.png"));
		Thread.sleep(1000);
		page.locator("//select[@id='select']").click();
		//screen shot
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/Html_Page.png")));
		Thread.sleep(1000);
		
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
		//Select Multiple
		String[] multSelectionValues =  {"Option One", "Option Three"};
		page.selectOption("//select[@id='select_multiple']", multSelectionValues);
		
		//Select Animal
		//page.selectOption("//select[@id='select_animal']", "Cat");

		//page.locator("//input[@id='ic']").click();
		Locator element=page.locator("#ic").first();
		String actualColor=(String)element.evaluate("e1=> getComputedStyle(e1).color");
		String expectedColor="rgb(0, 0, 0)";
		if(actualColor.equals(expectedColor)) {
			System.out.println("Color is as expected: "+actualColor);
		}else {
			System.out.println("Color is no as expected: "+actualColor);
		}
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
		//data list 
		String inputSelector="//input[@id='idl']";
		page.fill(inputSelector,"Example #2");
		//Date Input
		//LocalDate currentDate =LocalDate.now();
	
		//find text in 3rt Row and 2 col
		//System.out.println( page.locator("//tr[3]/td[2]").innerText() );
		//verify color input
		String exptColor = page.locator("#ic").getAttribute("Value");
		if("#00001".equals(exptColor)) {
			System.out.println("Color is as expected: "+actualColor);
		}else {
			System.out.println("Color is no as expected: "+actualColor);
		}
		//Verify Color input
		//page.locator("//input[@id='ic']").click();
//		Locator element=page.locator("#ic").first();
//		String actualColor=(String)element.evaluate("e1=> getComputedStyle(e1).color");
//		String expectedColor="rgb(0, 0, 0)";
//		if(actualColor.equals(expectedColor)) {
//			System.out.println("Color is as expected: "+actualColor);
//		}else {
//			System.out.println("Color is no as expected: "+actualColor);
//		}
		

		//Verify actual address match with expected address
		
//				String addressExpected = "              Written by <a href=\"mailto:webmaster@example.com\">Jon Doe</a>.<br>\r\n" + 
//						"              Visit us at:<br>\r\n" + 
//						"              Example.com<br>\r\n" + 
//						"              Box 564, Disneyland<br>\r\n" + 
//						"              USA" +
//						"              ";
//				String actualAddress = page.locator("//address").innerHTML();
//				if (addressExpected.equals(actualAddress)) 
//					System.out.println("Address is accurate - Pass");
//				else
//					System.out.println("Address is not accurate - FAILED");
//		//video 
//		BrowserContext context=browser
//				.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))); 
//			Page page;
//			page = context.newPage();
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
