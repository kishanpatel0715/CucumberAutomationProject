package helper;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class Hooks {
	
public WebDriver driver;
	
	public Hooks()
	{
		System.out.println("Hook constructor is invoked");
		this.driver = Browser.driver;	
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
		
	@After (order=1)
	public void teardown1()
	{
		driver.quit();
	}
		
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
	public void bstep()
	{
		System.out.println("BaforeSteppppppppppppppppppppppppppppppppppppppppppp");
	}
	
	@AfterStep
	public void astep()
	{
		System.out.println("AfterStepppppppppppppppppppppppppppppppppppppppppppppp");
	} */
}
