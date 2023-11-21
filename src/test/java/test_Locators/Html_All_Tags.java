  package test_Locators;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Html_All_Tags {

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
		// Input Text
		// Used CSS
		page.locator("#input__text").fill("Hello Plyawright");

		// Input Password
		// Used getByPlaceholder
		page.getByPlaceholder("Type your Password").fill("12345");

		// Input Web Address
		// Used X-path
		page.locator("//input[@id=\"input__webaddress\"]").fill("https://yoursite.com");

		// Input Email Address
		// Used getByLable
		page.getByLabel("Email Address").fill("@gmail.com");

		// Input Phone Numbers
		// Used Css
		page.locator("#input__phone").fill("2345345");

		// Type Search item
		// Used getByText
		page.getByText("Search").type("What is my Locators name");

		// Input Number (Up down arrows)
		// Used X-path
		for (int i = 0; i < 3; i++) {
			page.press("//*[@id='input__text2']", "ArrowUp");
			// page.press("//*[@id=\"input__text2\"]", "ArrowDown");
		}

		// Input File
		// Used X-path
		//File Upload
		page.setInputFiles("//input[@id='input__file']", Paths.get("./src/test/resources/files/rosylogo.png"));
		Thread.sleep(1000); 
		//page.locator("//input[@id='input__file']").setInputFiles(  Paths.get("C:\\java\\my_dairy.txt")   );
		//page.locator("//*[@id=\"input__file\"]").setInputFiles(Paths.get("C:\\Java\\webpage\\Bangladesh.jpg"));

		// (===============================================)
		// Select single menus
		page.selectOption("select", "Option Three");
		
		// Select multiple menus
		String selectSelector = "#select_multiple";
		// Select multiple options from the multi-select menu
		String[] valuesToSelect = { "Option One", "Option Two", }; // Replace with the values you want to select
		page.selectOption(selectSelector, valuesToSelect);

		// Multiple check boxes
		// Locator block = page.locator("//*[@id='forms__checkbox']");
		Locator checkboxes = page.locator("[type='checkbox']");
		for (int i = 1; i < checkboxes.count(); i++) {
			checkboxes.nth(i).click();
		}

		// Select radio buttons
		page.locator("//*[@id='forms__radio']/ul/li[3]/label").click();

		// Test Areas
		page.locator("//*[@id='textarea']").type("This is Test Web Side in Playwright");

		// (Clss02 ===============================================)

		// Verify Color input
//		String color = "#00D5FF";
//		 page.fill("#ic", color);
		String actualColor = page.locator("#ic").getAttribute("value");
		if ("#000000".equals(actualColor)) {
			System.out.println("Color Test1 case pass");
		} else {
			System.out.println("Color Test1 case fail");
		}

		// Number Input
		// page.locator("#in").fill("3");
		for (int i = 0; i < 4; i++) {
			// page.press("#in", "ArrowUp");
			page.press("#in", "ArrowDown");

		}

		// Range Input
		Locator slider = page.locator("//*[@id='ir']");

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		page.mouse().move(slider.boundingBox().x + slider.boundingBox().width / 2,
				slider.boundingBox().y + slider.boundingBox().height / 2);

		page.mouse().down();

		page.mouse().move(slider.boundingBox().x + 100, slider.boundingBox().y + slider.boundingBox().height / 2);

		page.mouse().up();

		// Date Input
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.toString(); // Format the date as per your requirements
		System.out.println(formattedDate);
		// Fill the date input field with the current date
		page.fill("//*[@id='idd']", formattedDate);

		// Month Input
		// Get the current month in the desired format
		YearMonth currentMonth = YearMonth.now();
		String formattedMonth = currentMonth.toString(); // Format the month as per your requirements
		System.out.println(formattedMonth);
		// Fill the date input field with the current month
		page.fill("#idm", formattedMonth);

		// Week Input
		// Input the week value
		// String weekValue = "2023-W45"; // Replace with the desired week value
		// page.fill("#idw", weekValue);

		// Get the current week in the desired format
		LocalDate nows = LocalDate.now();
		String currentWeek = nows.format(DateTimeFormatter.ofPattern("yyyy-'W'ww", Locale.US));
		page.fill("#idw", currentWeek);

		// Time Input
		// Get the current date and time in the desired format
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		String dateTimeValue = now.format(formatter);
		page.fill("#idt", dateTimeValue);

		// Date time-local input
		// Get the current date and time in the desired format
		LocalDateTime nowss = LocalDateTime.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		String dateTimeValues = nowss.format(formatters);
		page.fill("#idtl", dateTimeValues);

		// DataList
		page.fill("#idl", "Example #2");
		
		// Web Table Handling
		// Total Row count
		System.out.println("Row "+page.locator(".dataTable>tbody").locator("tr").count());
		
		//Total Column count
		System.out.println("Column "+page.locator(".dataTable>tbody>tr").locator("td").count());
		
		// First-child column count
		System.out.println("First Child Column "+page.locator(".dataTable>tbody").locator("tr:first-child").locator("td").count());
		
		// Second-child column count
		System.out.println("Second Child Column "+page.locator(".dataTable>tbody").locator("tr:nth-child(2)").locator("td").count());
		
		// Verify column Text
	//	assertThat(page.locator(".dataTable>tbody").locator("tr:first-child").locator("td:nth-child(2)")).hasText("Table Cell 2");
		
		// Total table Text print(used lambda)
		page.locator(".dataTable>tbody").allInnerTexts().forEach(text -> System.out.println(text));
		
		
		// Verify Pre-formatted text
		String welcomeMsg = page.textContent("#text__code > div > h2");
		if (welcomeMsg.contains("Pre-formatted text"))
			System.out.println("Test2 is Pass");
		else
			System.out.println("Test2 is Fail");
		

	}

}
