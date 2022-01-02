package selenium_practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadingAndDownloading {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// To know the current directory
		String downloadPath = System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://smallpdf.com/pdf-to-word");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[contains(text(),'Choose Files')]")).click();
		Thread.sleep(4000);
		Runtime.getRuntime().exec("C:\\Users\\thotav3\\Documents\\fileUpload.exe");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Scanned pages will convert to images in Word.')]")));
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Scanned pages will convert to images in Word.')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Choose option')]")).click(); 
		//Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("DOWNLOAD")));
		driver.findElement(By.linkText("DOWNLOAD")).click();
		
		Thread.sleep(5000);
		
		File file = new File(downloadPath+"/Veera_Automation Testing_5.10 Yrs_Resume-converted.docx");
		
		if(file.exists()) {
			
			// Ensure file is download or not
			Assert.assertTrue(file.exists());
			System.out.println("File is present");
			
			// delete the download file
				if(file.delete()) {
					System.out.println("File is Deleted");
				}
			
		}

	}

}
