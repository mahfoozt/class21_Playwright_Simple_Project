package testCaes_AUI;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Drop_And_Drag {

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
		 
		 page.navigate("https:jqueryui.com");		
		System.out.println( page.title() );
		Thread.sleep(2000);
		page.locator("//a[text()='Droppable']").click();
		
		
//		Locator draggable=page.locator("#draggable");
//		Locator droppable=page.locator("#droppable");
//		page.mouse().move(draggable.boundingBox().x+draggable.boundingBox().width/2,draggable.boundingBox().y+draggable.boundingBox().height/2);
//		page.mouse().down();
//		page.mouse().move(droppable.boundingBox().x+droppable.boundingBox().width/2,droppable.boundingBox().y+droppable.boundingBox().height/2);
		
		//Locator locator = page.frameLocator("iframe").getByText("Drag me to my target");
		//locator.click();
		//page.frameByUrl("https://jqueryui.com/droppable/");
		//page.mainFrame();
		//Locator source = page.locator("//p[text()='Drag me to my target']");
		//Locator target = page.locator("//div[@id='droppable']");
		//source.dragTo(target);
		
		
//		//drag and drop
//		page.locator("#item-to-be-dragged").dragTo(page.locator("#item-to-drop-at"));
//		page.locator("#item-to-be-dragged").hover();
//		page.mouse().down();
//		page.locator("#item-to-drop-at").hover();
//		page.mouse().up();	
		
//		source.dragTo(target);
		// or specify exact positions relative to the top-left corners of the elements:
//		source.dragTo(target, new Locator.DragToOptions()
//		  .setSourcePosition(34, 7).setTargetPosition(10, 20));
//		
		//page.close();
		//browser.close();
		//playwright.close();
	}

}
