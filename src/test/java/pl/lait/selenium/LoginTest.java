package pl.lait.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.ReservationPage;
import pl.lait.pageObjects.ReservationPage2;

@Ignore
public class LoginTest {

	WebDriver driver;
	
	@Before
	public void bifor() {                            //PageObjectPattern - wzorzec tworzenia testów gdzie definicje guzików przekładamy do oddzielnej klasy, do któej testy sie odwolują - wtedy zmiana w tej klasie pociaga za soba zmiany w testach
		driver = Init.getDriver();
	}
	
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("Gosiek1982", "Gosiek1982");
	}
	
	@Test
	public void reserveTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("Gosiek1982", "Gosiek1982");
		ReservationPage rp = new ReservationPage();
		rp.passCount("2");
		rp.from("Frankfurt", "3", "16");
		rp.to("London",  "3", "20");
		rp.firstClass();
		rp.submit();
		//2gi etap
		ReservationPage2 rp2 = new ReservationPage2();
		rp2.selectFlights(2,4);
		rp2.submit();
		//3etap
		rp2.pass0("Jan", "Nowak", "KSML");
		Init.sleep(3);
		rp2.submit2();
		rp2.logOut();
		
		
		
		
	}
	
	//after each test
	@After
		public void awter() {
			Init.close();
			// tu trzeba zamknąć przeglądarkę
			
			
}
}

