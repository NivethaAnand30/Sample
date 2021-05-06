package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Facebook {
	public static final String USERNAME = "nivetha22";
	public static final String ACCESS_KEY = "qG7FPpyysT2JzLg55LbM";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test(dataProvider="getData")
	private void launch(Platform os,String browser,String version) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(os);
		cap.setBrowserName(browser);
		cap.setVersion(version);

		URL browserStackUrl = new URL(URL);

		WebDriver driver = new RemoteWebDriver(browserStackUrl, cap);

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		WebElement txtEmail = driver.findElement(By.id("email"));

		txtEmail.sendKeys("anu@gmail.com");

		WebElement txtPass = driver.findElement(By.id("pass"));

		txtPass.sendKeys("anu87658");

		String url = driver.getCurrentUrl();
		System.out.println(url);

		driver.quit();

	}

	@DataProvider(parallel=true)
	private Object[][] getData() {

		return new Object[][] {

				{ Platform.MAC, "chrome", "70" }, { Platform.WIN8, "firefox", "65" },
				{ Platform.WINDOWS, "firefox", "65" },

		};
	}

}

















