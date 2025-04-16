package helper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;

public class DownloadHelper {

	WebDriver driver;
	
	public DownloadHelper()
	{
		driver = Browser.driver;
	}
	
	public static void waitForDownload(String fileName) throws InterruptedException
	{
		File partialFilePath = new File(ConfigReader.get("downloadPath"));
	    Path fullDowlnloadedFilePath = Paths.get(partialFilePath.getAbsolutePath(), fileName);
	
	    File fullFilePath = new File(fullDowlnloadedFilePath.toString());
	    
	    for (int i = 0; i < 30; i++)
	    {
	        if (fullFilePath.exists())
	        {
	            break;
	        }
	        else
	        {
	            Thread.sleep(10);
	        }
	    }
	}
}