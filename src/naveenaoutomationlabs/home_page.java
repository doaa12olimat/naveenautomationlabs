package naveenaoutomationlabs;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class home_page extends parameters {

	@Test(priority = 1)
	public void Search_MacBook() throws InterruptedException, IOException {
		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Maximize window
		//driver.manage().window().maximize();

		// Vertical scroll down by 600 pixels
		js.executeScript("window.scrollBy(0,600)");

		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("MacBook");// search MacBook
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]"));
		List<WebElement> list = driver.findElements(By.className("product-thumb"));// add to card
		for (int i = 0; i < list.size(); i++) {
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[3]/div/div[2]/div[2]/button[1]")).click();
		}

		Thread.sleep(9000);
		String expected = "3";
		driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
		Thread.sleep(9000); // test total item in the card String Total =
		String Total = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[3]")).getText();
		// screenshot
		Date curentdate = new Date();
		System.out.println(curentdate);
		String screenfilename = curentdate.toString().replace(":", "-");
		String screenfilenamenew = screenfilename.substring(11, 19);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(".//screenshot//" + screenfilenamenew + ".png");
		FileUtils.copyFile(SrcFile, DestFile);

		System.out.println(Total);
		String s = Total.substring(2);
		System.out.println(s);
		myAssertion.assertEquals(s, expected);
		myAssertion.assertAll();
		//driver.navigate().back();

	}

	// this test for test price

	@Test(priority = 3)
	public void testlogin() throws InterruptedException, IOException {
		driver.get("https://naveenautomationlabs.com/opencart/");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();

		WebElement Dropdwn = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul"));
		List<WebElement> list1 = Dropdwn.findElements(By.tagName("li"));
		System.out.println(list1.size());
		for (int i = 0; i < list1.size(); i++) {
			if (i == 0) {
				list1.get(0).click();
			}

		}
		Thread.sleep(9000); // now send information for log in
		driver.findElement(By.xpath("//*[@id=\"account\"]"));
		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("doaa");
		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("olimat");
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("doaa5@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("123456789");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]"));
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("doaa");
		driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("doaa");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		// screenshot
				Date curentdate = new Date();
				System.out.println(curentdate);
				String screenfilename = curentdate.toString().replace(":", "-");
				String screenfilenamenew = screenfilename.substring(11, 19);
				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile = new File(".//screenshot//" + screenfilenamenew + ".png");
				FileUtils.copyFile(SrcFile, DestFile);
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a/i")).click();
		
	}

	@Test(priority = 4)
	public void registurtest() throws InterruptedException, IOException {
		driver.get("https://naveenautomationlabs.com/opencart/");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		// myAcount

		WebElement Dropdwn = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul"));
		// Registerfrom list
		List<WebElement> list1 = Dropdwn.findElements(By.tagName("li"));

		for (int i = 0; i < list1.size(); i++) {
			if (i == 1) {
				list1.get(1).click();
			}

		}
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]"));
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("doaa5@gmail.com");// send email
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("doaa");
		// send password
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(5000); // click camera from list
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]"));
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[7]/a")).click();
		Thread.sleep(9000); // clear card
		driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button")).click();
		// add nokia camera to the card
		WebElement Prodect = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]"));
		List<WebElement> listProdect = Prodect.findElements(By.className("product-thumb"));
		System.out.println(listProdect.size());
		for (int i = 0; i < list1.size(); i++) {
			if (i == 1) { // add camera nokia to the card
				driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[1]/h4/a")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).sendKeys("2");
				// add two item
				driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
				Thread.sleep(3000);
				// screenshot
				Date curentdate = new Date();
				System.out.println(curentdate);
				String screenfilename = curentdate.toString().replace(":", "-");
				String screenfilenamenew = screenfilename.substring(11, 19);
				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile = new File(".//screenshot//" + screenfilenamenew + ".png");
				FileUtils.copyFile(SrcFile, DestFile);
				String MsgCheckAdd = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
				String Expected = "Success";
				
				String Actual = MsgCheckAdd.substring(0, 7);
				// test if item add to card myAssertion.assertEquals(Actual, Expected);
				myAssertion.assertAll();
			}

		}

	}

	@AfterTest
	public void myAfterTest() throws IOException {
		myAssertion.assertAll();

	}

}
