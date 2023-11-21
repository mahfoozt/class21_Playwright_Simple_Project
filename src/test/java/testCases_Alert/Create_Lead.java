package testCases_Alert;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Create_Lead {

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
		
		page.navigate("http://leaftaps.com/opentaps");
		//Get page title
		System.out.println(page.title());
		Thread.sleep(2000);
		//Enter user name
		page.locator("//input[@id='username']").fill("DemoSalesManager");
		Thread.sleep(2000);
		//Enter password name
		page.locator("//input[@id='password']").fill("crmsfa");
		//click login button
		page.locator("//input[@class='decorativeSubmit']").click();
		Thread.sleep(2000);
		//Click CRMSFA
		page.locator("text=CRM/SFA").click();
		Thread.sleep(2000);
		//click create lead
		Thread.sleep(2000);
		page.locator("//a[text()='Create Lead']").click();
		Thread.sleep(2000);
		//Enter company name
		page.locator("//input[@id='createLeadForm_companyName']").fill("CTS");
		Thread.sleep(2000);
		//Enter First name
		page.locator("//input[@id='createLeadForm_firstName']").fill("Hema");
		Thread.sleep(2000);
		//Enter Last name
		page.locator("//input[@id='createLeadForm_lastName']").fill("Mali");
		Thread.sleep(2000);
		//Enter Title-----------Ms.  
		page.locator("//input[@id='createLeadForm_generalProfTitle']").fill("Ms");
		Thread.sleep(2000);
		//Enter Description.....TCS
		page.locator("//textarea[@id='createLeadForm_description']").fill("TCS");
		Thread.sleep(2000);
		//Enter Country Code ----1
		page.locator("//input[@id='createLeadForm_primaryPhoneCountryCode']").fill("1");
		Thread.sleep(2000);
		//Enter Department-----MKT
		page.locator("//input[@id='createLeadForm_departmentName']").fill("MKT");
		Thread.sleep(2000);
		//Enter Number of Employee----100
		page.locator("//input[@id='createLeadForm_numberEmployees']").fill("100");
		Thread.sleep(2000);
		//Enter Web Url ------------google.com
		page.locator("//input[@id='createLeadForm_primaryWebUrl']").fill("google.com");
		Thread.sleep(2000);
		//Enter Zip Code ----------75061
		page.locator("//input[@id='createLeadForm_generalPostalCode']").fill("75061");
		Thread.sleep(2000);
		//Enter Phone Number ------123456
		page.locator("//input[@id='createLeadForm_primaryPhoneNumber']").fill("123456");
		Thread.sleep(2000);
		//Enter Email Address ----abc@gmail.com
		page.locator("//input[@id='createLeadForm_primaryEmail']").fill("abc@gmail.com");
		// Click Create lead
		page.locator("//input[@name='submitButton']").click();
		Thread.sleep(2000);		
		//Verify the First name	
		System.out.println("***********Create Lead HW*************************");
		Thread.sleep(2000);
		System.out.println("Verify First Name is Hema");
		System.out.println("Hema");
		String firstName1 = page.textContent("//span[text()='Hema']");
		if (firstName1.contains("Hema")) {
			System.out.println("First Name Hema is Matched");
		}else { System.out.println("First Name Hema is Not Matched");
		}
		System.out.println("***********Create Lead HW Done*******************");
		//Again take the Screen Shot
		//Screen Shot
		Thread.sleep(1000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/Snap_Shot_Folder/Create_Lead.png")));
		Thread.sleep(1000);

	}

}
