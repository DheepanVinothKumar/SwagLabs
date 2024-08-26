package com.swagBaseClass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	protected static WebDriver driver;

	public static ExtentReports extentreports;

	public static File file;

	protected static WebDriver browser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (browsername.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static void url(String urlLnk) {
		driver.get(urlLnk);
	}

	// Deleting Cookies
	protected void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	// WebElement Methods
	protected void passInput(WebDriver driver, WebElement element, String input) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.sendKeys(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void clickOnElement(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void deleteInput(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getText(WebDriver driver, WebElement element) {
		try {
			return element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected boolean isEnabled(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}

	protected boolean isDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected boolean isSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}

	// Screenshot Method
	protected static void takeScreenShot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sor = ts.getScreenshotAs(OutputType.FILE);
		File Des = new File("C:\\Users\\mvion\\eclipse-workspace\\SeleniumProject\\ScreenShot\\" + filename + ".png");
		try {
			FileHandler.copy(sor, Des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void extentReportStart(String location) {
		extentreports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentreports.attachReporter(sparkReporter);
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("Java Version", System.getProperty("Java Version"));
	}

	public static void extentReportTearDown(String location) throws IOException {
		extentreports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}

	public static void validationtitle(WebDriver act, String ect) {
		Assert.assertEquals(act.getTitle(), ect);
	}

	public static void validationelement(WebElement act, String ect) {
		Assert.assertEquals(act.getText(), ect);
	}

	// Java Script Executor Methods
	protected void scroll(WebDriver driver, int x, int y) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ");");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void jsClick(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void jsScrollAndClick(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Wait Methods
	protected void expliciWaitVisible(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void staticWait(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void selectFromDropDown(WebDriver driver, WebElement element, String option, String value) {

		try {
			Select s = new Select(element);
			if (option.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(value));
			} else if (option.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibleText")) {
				s.selectByVisibleText(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Alert Method
	protected void confirmAlert(WebDriver driver, WebElement element, String condition) {
		try {
			Alert confirm_alert = driver.switchTo().alert();
			if (condition.equalsIgnoreCase("accept")) {
				confirm_alert.accept();
			} else if (condition.equalsIgnoreCase("dismiss")) {
				confirm_alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Mouse Actions Methods
	protected void dragAndDrop(WebDriver driver, WebElement element, WebElement element1) {
		try {
			new Actions(driver).dragAndDrop(element, element1).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void mouseHover(WebDriver driver, WebElement element) {
		try {
			new Actions(driver).moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Switch To Window or Tab Method
	protected static void switchWindow(WebDriver driver, int index) {
		try {
			Set<String> all_tab_id = driver.getWindowHandles();
			List<String> tab_id_list = new LinkedList<>(all_tab_id);
			driver.switchTo().window(tab_id_list.get(index));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Switch To Frame Methods
	protected void frameUsingName(WebDriver driver, String name) {
		try {
			driver.switchTo().frame(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void frameUsingElement(WebDriver driver, WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Navigate Methods
	protected void navigateTo(WebDriver driver, String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void previousPage(WebDriver driver) {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void nextPage(WebDriver driver) {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void refreshPage(WebDriver driver, WebElement element) {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getCurrentUrl(WebDriver driver) {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	protected String getTitle(WebDriver driver) {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	protected static void close(WebDriver driver) {
		driver.close();
	}

	protected static void quit(WebDriver driver) {
		driver.quit();
	}

}
