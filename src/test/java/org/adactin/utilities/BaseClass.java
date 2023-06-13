package org.adactin.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor javascriptexecutor;
	public static Actions actions;
	public static Select select;
	public static Alert a;
	public static Sheet sheet;
	public static Robot robot;

	// 1
	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void launchFireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void clearWebElement(WebElement element) {
		element.clear();

	}

	// 2
	public static void launchUrl(String url) {
		driver.get(url);
	}

	// 3
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 4
	public static String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	// 5
	public static String pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	// 6
	public static void quitBrowser() {
		driver.quit();
	}

	// 7
	public static void closeWindow() {
		driver.close();
	}

	// 8
	public static void enterText(WebElement element, String text) {

		element.sendKeys(text);
	}

	// 9
	public static String getAttributeValue(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;

	}

	// 10
	public static void clickElement(WebElement element) {
		element.click();

	}

	// 11
	public static void pauseExecution(int millis) {
		try {
			Thread.sleep(millis);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	// 12
	public static void applyWaitForAllElement() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// WindowHandling

	// 13
	public static String getParentWindowId() {
		String parentid = driver.getWindowHandle();
		return parentid;
	}

	// 14
	public static Set<String> allWindowId() {
		Set<String> allIds = driver.getWindowHandles();
		return allIds;
	}

	// 15
	public static void switchTochildWindow(Set<String> allIds, String parentId) {
		for (String s : allIds) {
			if (!s.equals(parentId)) {
				driver.switchTo().window(s);
			}
		}
	}

	// 16
	public static void SwitchToWindow(Set<String> allIds, int index) {
		List<String> list = new ArrayList<String>();
		list.addAll(allIds);
		driver.switchTo().window(list.get(index));

	}

	// 17
	public static void switchToWindoByUrl(String url) {
		driver.switchTo().window(url);
	}

	// 18
	public static void switchToWindByTitle(String title) {
		driver.switchTo().window(title);

	}

	// Actions

	// 19
	public static void moveCursor(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	// 20
	public static void dragdrop(WebElement sourceElement, WebElement targetElement) {
		actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();

	}

	// 21
	public static void doubleClickMouse(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// 22
	public static void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	// Select Class

	// 23
	public static String getSelectedOption(WebElement element) {// 1
		select = new Select(element);

		String firstSelectedOption = select.getFirstSelectedOption().getText();
		return firstSelectedOption;

	}

	// 24
	public static void selectValue(WebElement element, String value) {// 2

		select = new Select(element);
		select.selectByValue(value);

	}

	// 25
	public static void selectVisibileText(WebElement element, String text) {// 3
		select = new Select(element);
		select.selectByVisibleText(text);

	}

	// 26
	public static void selectIndex(WebElement element, int index) {// 4
		select = new Select(element);
		select.selectByIndex(index);

	}

	// 27
	public static boolean isMultipleCheck(WebElement element) {// 5
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 28
	public static void deselectAllCheck(WebElement element) {// 6
		select = new Select(element);
		select.deselectAll();
	}

	// 29
	public static void deselectValue(WebElement element, String value) {// 7
		select = new Select(element);
		select.deselectByValue(value);
	}

	// 30
	public static void deselectVisibileTex(WebElement element, String text) {// 8
		select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 31
	public static void deselectIndex(WebElement element, int index) {// 9
		select = new Select(element);
		select.deselectByIndex(index);
	}

	// 35
	public static List<WebElement> getAllOption(WebElement element) {// 10
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// vibility check

	// 32
	public static boolean isDisplayedCheck(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 33
	public static boolean isEnableCheck(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	// 34
	public static boolean isSelectedCheck(WebElement element) {
		boolean selected = element.isSelected();
		return selected;

	}

	// Navigation

	// 36
	public static void toNavigation(String url) {
		driver.navigate().to(url);

	}

	// 37
	public static void forwardNavigation() {
		driver.navigate().forward();

	}

	// 38
	public static void backNavigation() {
		driver.navigate().back();
	}

	// 39
	public static void referesePage(String url) {
		driver.navigate().refresh();
	}

	// Frames

	// 40
	public static void frameSwitchByid(String name) {
		driver.switchTo().frame(name);
	}

	// 41
	public static void frameSwitchByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 42
	public static void frameSwitchByWebElement(WebElement element) {
		driver.switchTo().frame(element);

	}

	// 45
	public static void switchParentFrame() {
		driver.switchTo().parentFrame();
	}

	// 46
	public static void defaultContentSwitch() {
		driver.switchTo().defaultContent();
	}

	// Javascript Execiution

	// 43
	public static void scrollDown(WebElement element) {
		javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	// 44
	public static void scrollUp(WebElement element) {
		javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void enterTextJs(WebElement element, String text) {
		javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}

	// Alert

	// 47
	public static void alertHandle() {
		driver.switchTo().alert();
	}

	// 48
	public static void acceptAlert() {
		a.accept();
	}

	// 49
	public static void dismissAlert() {
		a.dismiss();
	}

	// 50
	public static void sendkeysAlert(String text) {
		a.sendKeys(text);

	}

	// 51
	public static void getText() {
		a.getText();
	}

	public static String excelRead(int rowNo, int cellNo, String filename, String SheetName) throws IOException {

		File f = new File("C:\\Users\\jayaselvamjai\\eclipse-workspace\\MavenTest\\ExcelSheet\\" + filename + ".xlsx");

		FileInputStream fileRead = new FileInputStream(f);

		Workbook work = new XSSFWorkbook(fileRead);

		Sheet s = work.getSheet(SheetName);

		Row row = s.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();

		String text = "";

		if (cellType == 1) {

			text = cell.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(cell)) {
			// date
			Date d = cell.getDateCellValue();

			System.out.println("old formated " + d);

			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");

			text = sim.format(d);

		} else {

			// number

			double d = cell.getNumericCellValue();

			// typeCast

			long l = (long) d;

			text = String.valueOf(l);

		}
		return text;
	}

	public static void createExcel(String filename, String sheetname) throws IOException {

		File f = new File("C:\\Users\\jayaselvamjai\\eclipse-workspace\\MavenTest\\ExcelSheet\\" + filename + ".xlsx");

		Workbook work = new XSSFWorkbook();

		sheet = work.createSheet(sheetname);

		FileOutputStream fout = new FileOutputStream(f);
		work.write(fout);

	}

	public static void createRow(String filename, String sheetname, int rowNo) throws IOException {

		File f = new File("C:\\Users\\jayaselvamjai\\eclipse-workspace\\MavenTest\\ExcelSheet\\" + filename + ".xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook work = new XSSFWorkbook(fin);
		sheet = work.getSheet(sheetname);
		sheet.createRow(rowNo);
		FileOutputStream fout = new FileOutputStream(f);
		work.write(fout);

	}

	public static void createCell(String filename, String sheetname, int rowNo, int cellNo, String cellValue)
			throws IOException {

		File f = new File("C:\\Users\\jayaselvamjai\\eclipse-workspace\\MavenTest\\ExcelSheet\\" + filename + ".xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook work = new XSSFWorkbook(fin);
		sheet = work.getSheet(sheetname);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(cellValue);
		FileOutputStream fout = new FileOutputStream(f);
		work.write(fout);

	}

	public static void ExcelPrintAllData(String filename, String sheetname) throws IOException {
		File f = new File("C:\\Users\\jayaselvamjai\\eclipse-workspace\\MavenTest\\ExcelSheet\\" + filename + ".xlsx");
		FileInputStream fileRead = new FileInputStream(f);
		Workbook work = new XSSFWorkbook(fileRead);
		Sheet s = work.getSheet(sheetname);
		int rowCount = s.getPhysicalNumberOfRows();
		for (int i = 0; i < rowCount; i++) {
			Row row = s.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();

				String text = "";

				if (cellType == 1) {

					text = cell.getStringCellValue();

				} else if (DateUtil.isCellDateFormatted(cell)) {
					// date
					Date d = cell.getDateCellValue();

					System.out.println("old formated " + d);

					SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");

					text = sim.format(d);

				} else {

					// number

					double d = cell.getNumericCellValue();

					// typeCast

					long l = (long) d;

					text = String.valueOf(l);

				}

				System.out.println(text);
			}
		}

	}

	public static String getTextElement(WebElement element) {

		String text = element.getText();

		return text;

	}

	public static String sendKeysElement(WebElement element, String text) {
		element.sendKeys(text);
		return text;
	}

	public static void downKey(int times) throws AWTException {
		robot = new Robot();
		for (int i = 0; i < times; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void tabKeyPress(int times) throws AWTException {
		robot = new Robot();
		for (int i = 0; i < times; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
	}
	
	public static void tripleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).click().perform();

	}
	public static void enterKeyPress(int times) throws AWTException {
		robot = new Robot();
		for (int i = 0; i < times; i++) {
			robot.keyPress(KeyEvent.VK_ENTER);	
			robot.keyRelease(KeyEvent.VK_ENTER);
}
}
}