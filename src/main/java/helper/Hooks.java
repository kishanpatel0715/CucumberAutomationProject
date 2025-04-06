package helper;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;


public class Hooks {
	
public WebDriver driver;
	
	public Hooks()
	{		
		System.out.println("Hooks Constructorrrrrrrrrrrrrrrrrrrrrrrrr");
		this.driver = Browser.driver;	
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	/*
	@Before (value = "@One", order =1)
	public void setup1()
	{
		System.out.println("11111111111111111111111111111111111111111111");		
	}
	
	
	@Before (order=2)
	public void setup2()
	{		
		System.out.println("2222222222222222222222222222222222222222222222");	
	} */
		
	/*
	@After (order=2)
	public void teardown2()
	{
		System.out.println("4444444444444444444444444444444444444444444444");
		driver.quit();
	}
	*/

	/*
	@BeforeStep
	public void beforeStep()
	{
		System.out.println("BaforeSteppppppppppppppppppppppppppppppppppppppppppp");
	}
	
	@AfterStep
	public void afterStepstep()
	{
		System.out.println("AfterStepppppppppppppppppppppppppppppppppppppppppppppp");
	} */
}
