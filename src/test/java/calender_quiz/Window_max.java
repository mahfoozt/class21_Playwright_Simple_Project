package calender_quiz;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Window_max {

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
		Thread.sleep(1000);
		//BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		//ArrayList <String> argument= new ArrayList<>();
		//argument.add("--start-maximized");
		//argument.add("--start-maximized");
		// Input Text
		page.locator("#input__text").click();
		Thread.sleep(1000);
		page.locator("#input__text").fill("mahfooz");
		Thread.sleep(1000);
		//Input Password
		page.locator("#input__password").click();
		Thread.sleep(1000);
		page.locator("#input__password").fill("1234@56");
		//Input Email Address
		Thread.sleep(1000);
		page.locator("//input[@id='input__webaddress']").fill("https://github.com/mahfoozt/");
		Thread.sleep(1000);
		page.locator("//input[@id='input__emailaddress']").fill("mahfooz.murshalin@gmail.com");
		//Input Phone Numbers [Used Css ]
		Thread.sleep(1000);
		page.locator("#input__phone").fill("480-234-5678");
		//Type Search item
		Thread.sleep(1000);
		page.locator("//input[@id='input__search']").fill("Flower");
		//Input Number (Up and Down arrows)
		Thread.sleep(2000);
		//page.locator("//input[@id='input__text2']").fill("2");
		for(int i=0; i< 4; i++ ) {
			page.press("//input[@id='input__text2']","ArrowUp");
			//page.press("//input[@id='input__text2']","ArrowDown");
		}
		//Input File
		Thread.sleep(1000);
		//page.locator("//input[@id='input__file']").setInputFiles(Paths.get("./src/test/resources/files/rosylogo.png"));
		page.setInputFiles("//input[@id='input__file']", Paths.get("./src/test/resources/files/rosylogo.png"));
		//-----------------------------------------------------------------------------------------------------
		Thread.sleep(1000);
		//Select City
		page.selectOption("//select[@id='select_city']","Austin");
		Thread.sleep(1000);
		//Select Animal
		page.selectOption("//select[@id='select_animal']","Cat");
		Thread.sleep(1000);		
		// Select multiple menus
		String selectSelector = "#select_multiple";
		// Select multiple options from the multi-select menu
		String[] valuesToSelect = { "Option One", "Option Two", }; // Replace with the values you want to select
		page.selectOption(selectSelector, valuesToSelect);
		Thread.sleep(1000);
		//------------------------------------------------------------------------------------------------
		// Multiple check boxes
		Locator checkboxes = page.locator("[type='checkbox']");
		for (int i = 1; i < checkboxes.count(); i++) {
			checkboxes.nth(i).click();
		}
		// Select radio buttons
		page.locator("//*[@id='forms__radio']/ul/li[3]/label").click();
		//right in Text Area
		Thread.sleep(1000);
		page.locator("//textarea[@id='textarea']").click();
		Thread.sleep(2000);
		page.locator("//textarea[@id='textarea']")
				.fill("Hello everyone, this is Mahfooz. I am working as an intern at Michro Tech.");
		Thread.sleep(1000);
		//------------------------------------------------------------------------------------------
		//verify color input
		String exptColor = page.locator("#ic").getAttribute("Value");
		if("#000001".equals(exptColor)) {
			System.out.println("Color is as expected: "+exptColor);
		}else {
			System.out.println("Color is not as expected: "+exptColor);
		}
		Thread.sleep(3000);
//		//Color input
//		String color ="#00D5FF";
//		page.fill("//input[@id='ic']", color);
//		Thread.sleep(3000);
		
		// Number Input   //input[@id='in']
		//page.locator("//input[@id='in']").click();
		for(int i=5; i< 10; i++ ) {
			page.press("//input[@id='in']","ArrowUp");
			//page.press("#in","ArrowDown");
		}
		
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
		
		//Date Input
		Thread.sleep(2000);
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.toString();
		System.out.println("After update Date is now " + formattedDate);
		page.fill("//input[@id='idd']", formattedDate);
		
		//Month Input
		// Get the current month in the desired format
		Thread.sleep(1000);
		page.locator("//input[@id='idm']").click();
		YearMonth currentMonth=YearMonth.now();
		String formattedMonth= currentMonth.toString();
		System.out.println("After update Date is now : " + formattedMonth);
		//Fill the date input field with the current month
		page.fill("//input[@id='idm']", formattedMonth);
		
		//Week Input
		Thread.sleep(1000);
		page.locator("//input[@id='idw']").click();
		//Thread.sleep(1000);
		//String weekValue="2023-W45";
		//page.fill("//input[@id='idw']", weekValue);
		// Get the current week in the desired format
		LocalDate nows = LocalDate.now();
		String currentWeek = nows.format(DateTimeFormatter.ofPattern("yyyy-'W'ww", Locale.US));
		page.fill("#idw", currentWeek);
		// Time Input
		// Get the current date and time in the desired format
		Thread.sleep(1000);
		page.locator("//input[@id='idt']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='idt']").fill("2023-11-06T00:00:00Z");
		
		// Date time-local input
		// Get the current date and time in the desired format
		Thread.sleep(1000);
		page.locator("//input[@id='idtl']").click();
		Thread.sleep(1000);
		page.locator("//input[@id='idtl']").fill("2023-11-06T00:00");
		
		//Data List
		Thread.sleep(1000);
		page.locator("//input[@id='idl']").click();
		Thread.sleep(1000);
		String inputSelector="//input[@id='idl']";
		page.fill(inputSelector,"Example #2");

		//-----------------------------------------------------------------------------------------------	
		//Web table handling
		//Total row count
		int row= page.locator(".dataTable>tbody>tr").count();
		System.out.println("Total Row " +row );  
		//Total Column count
		int column= page.locator(".dataTable>thead>tr>th").count();
		System.out.println("Total Cloumn " + column );
		//First child Row count
		int ChildRow=page.locator(".dataTable>tbody>tr:first-child").count();
		System.out.println("First Child Row " + ChildRow);
		
		//First child Column count
		int ChildColumn=page.locator(".dataTable>tbody>tr:first-child>td").count();
		System.out.println("First Child Column " + ChildColumn);
		//Second child Column count
		//int ChildColumn1=page.locator(".dataTable>tbody>tr:second-child>td").count();
		//System.out.println("Second Child Column " + ChildColumn1);
		//Print Table Header
		System.out.println("----------------------Table Caption-----------------------------------------");
		System.out.println(page.locator("//h2[text()='Tabular data']").innerText());
		//Total Table Header print
		page.locator(".dataTable>thead").allInnerTexts().forEach( text  -> System.out.print( text ));
		 
		//Total Table text print
		page.locator(".dataTable>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		//Total Table Footer print
		page.locator(".dataTable>tfoot").allInnerTexts().forEach(text -> System.out.print(text));
		
		//find text in 3rd Row and 2 col is "Table Cell 12"
		System.out.println("-----Print Text in 3rd Row and 2nd col is \"Table Cell 12\"------------------");
	
		System.out.println( page.locator("//tr[3]/td[2]").innerText() );
		//verify Column Text
		assertThat(page.locator(".dataTable>tbody>tr:first-child>td:nth-child(3)")).hasText("Table Cell 3");
		
		//Verify Color input
//		String color ="#00D5FF";
//		page.fill("//input[@id='ic']", color);
//		Thread.sleep(3000);
//		String actualColor = page.locator("//input[@id='ic']").getAttribute("value");
//		Thread.sleep(2000);
//		if("#000000".equals(actualColor)) {
//			System.out.println("Color Test case is pass");
//		}else {
//			System.out.println("Color Test case is fail");
//		}		
//		
	
//		BrowserContext context = browser.newContext(new Browser
//								.NewContextOptions()
//								.setViewportSize(width,height));




	}

}
