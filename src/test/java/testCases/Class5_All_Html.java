package testCases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class5_All_Html {

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
		
		page.navigate("file:///C:/Java/SDET_Class/New_html-all.html");
		//Get page title
		System.out.println(page.title());
		Thread.sleep(2000);
		
		
		//File Upload
		//page.locator("//input[@id='input__file']").setInputFiles(Paths.get("C:\\java\\my_dairy.txt"));
		
		
		//Select Animal
		page.selectOption("//select[@id='select_animal']", "Cat");
		
		
		//Select Multiple
		String[] multSelectionValues =  {"Option One", "Option Two"};
		page.selectOption("//select[@id='select_multiple']", multSelectionValues);

		//Range Input
		Thread.sleep(2000);
		page.locator("//input[@id='ir']").click();
		Locator slider = page.locator("//input[@id='ir']");	
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		page.mouse().move(slider.boundingBox().x +slider.boundingBox().width/2, slider.boundingBox().y  + slider.boundingBox().height/2);
		page.mouse().down();
		page.mouse().move(slider.boundingBox().x + 100, slider.boundingBox().y + slider.boundingBox().height/2);
		page.mouse().up();
		//find text in 3rt Row and 2 col
		System.out.println( page.locator("//tr[3]/td[2]").innerText() );
		
//		int[] age = {23,56,78,45,61};
//		String[] name = {"23","56","78","45","61"};

	}

}
