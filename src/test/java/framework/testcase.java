package framework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class testcase extends capabilities
{
	AndroidDriver<AndroidElement> driver;
	

	@BeforeTest
	public void KillAllProcesses() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(8000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//emulator.bat");
		Thread.sleep(10000);
		
	}
	@Test
	public void tc1() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver= hybrid_capabilities(appactivity, apppackage, deviceName, chromeexcutable);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("sesi");
		
		driver.hideKeyboard();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
				
		
		Thread.sleep(5000);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		String price1=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		
		price1=price1.substring(1);
		
		Double cost1=Double.parseDouble(price1);
		System.out.println(cost1);
		
		String price2=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		price2=price2.substring(1);
		Double cost2=Double.parseDouble(price2);
		System.out.println(price2);
		Double Totalprice=cost1+cost2;
		System.out.println(Totalprice);
		
		
		
		String total=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		total=total.substring(1);
		
		double total1=Double.parseDouble(total);
		
		System.out.println(total1);
		
		if(Totalprice.equals(total1))
		{
			
			System.out.println("Price Matched");
		}
		else
		{
			
			System.out.print("Price not Matched");
		}
		
		
		Thread.sleep(5000);
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		driver.findElement(MobileBy.className("android.widget.Button")).click();
		

		
		
	}
  @Test(enabled=true)
  public void scrollconverse() throws InterruptedException
  {
	  Thread.sleep(5000);
	  driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("sesi");
		
		driver.hideKeyboard();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		String at= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").getText();
		Thread.sleep(5000);
		System.out.println(at);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		String s5=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productPrice")).getText();
		s5=s5.substring(1);
		Double u=Double.parseDouble(s5);
		System.out.println(u);
		Thread.sleep(5000);
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		Thread.sleep(5000);
		
		driver.findElement(MobileBy.className("android.widget.Button")).click();
		
	}


}

