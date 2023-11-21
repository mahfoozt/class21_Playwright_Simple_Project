package calender_quiz;

import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class South_West_Airlines {

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
	
		page.navigate("https://www.southwest.com/");
		
		ArrayList<String>argument= new ArrayList<>();
		argument.add("--start-maximized");
		//Get page title
		System.out.println( page.title() );
		page.locator("(//input[@class='input--text'])[2]").fill("PHX");
		Thread.sleep(1000);
		//Click on calendar icon near from the deperture date
		page.locator("(//div[@class='input--icon-separator'])[1]").click();
		Thread.sleep(1000);
		//String month = "November, 2022";
		//String day = "11";
		//enter departure day 24/11
		page.locator("(//button[@type='button'])[43]").click();
		Thread.sleep(1000);
		//click Return calender icon
		page.locator("(//div[@class='input--icon-separator'])[2]").click();		
		Thread.sleep(2000);
		page.locator("(//span[@class='swa-icon--icon'])[17]").click();
		Thread.sleep(2000);
		//enter Return day 20/12
		page.locator("(//button[@type='button'])[85]").click();	
		//click passenger icon
		Thread.sleep(1000);
		page.locator("(//input[@class='input--text'])[6]").click();
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Data/Itenary_pic.png")));
		//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Data/pic1.png")));
		
		Thread.sleep(1000);	
		System.out.println( page.title() );
		
		page.close();
		browser.close();
		playwright.close();
		
		
	}

}
