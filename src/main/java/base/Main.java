package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static WebDriver driver;
	public static Properties prop;
	
	public Main() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\"
					+ "FebMarMayBDDPOM\\src\\main\\java\\properties\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("qaTesturl"));
	}
	
	public void tearDown() {
		driver.close();
	}
}
