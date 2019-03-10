package pl.lait.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuTest {

	WebDriver driver;

	@Before
	public void bifor() {
		// otwieramy przeglądarkę przed testem
		Init.log("Otwieram okno przegladarki");
		driver = Init.getDriver();
	}
	@Test
	public void topMenu() {
		Init.log("Klikam w link CONTACT");
		driver.findElement(By.linkText("CONTACT")).click();
		Init.log("Klikam w link SUPPORT");
		driver.findElement(By.linkText("SUPPORT")).click();
		Init.sleep(5);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
		Init.log(driver.getTitle());
	}
	@After
	public void awter() {
		Init.close();
		// tu trzeba zamknąć przeglądarkę
	}
}
