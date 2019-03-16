package pl.lait.selenium;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //żeby była kolejność wykonywania testów ALFABETYCZNIE bo tak sobie selenium losowo wybiera
public class MenuTest {               //zeby działalo klasa musi konczyc się na test

	WebDriver driver;
	
	public void linkClick(String linkText) {
		Init.log("Klikam w link: " + linkText);
		driver.findElement(By.linkText(linkText)).click();  //tworzymy metode dla powtarzajacych sie czynnosci czyli click linktest
	}

	public void radioClick(String xpath) {
		Init.log("Klikam w element z Xpath " + xpath);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void listaRozwijalnaPoVisibleText (String name, String value) {
		Init.log("Wybieram: " + name);
		Select listaRozwijalnaPoVisibleText = new Select(driver.findElement(By.name(name))); 
		listaRozwijalnaPoVisibleText.selectByVisibleText(value);
			}
	
	public void listaRozwijalnaPoValue (String name, String value) {
		Init.log("Wybieram: " + name);
		Select listaRozwijalnaPoValue = new Select(driver.findElement(By.name(name))); 
		listaRozwijalnaPoValue.selectByValue(value);
		}
	
	
	@Before   //before each test
	public void bifor() {
		// otwieramy przeglądarkę przed testem
		Init.log("Otwieram okno przegladarki");
		driver = Init.getDriver();
	}
	//@Ignore
	@Test      //junit potraktuje to jako test i bedzie działało
	public void topMenu() {
		//Init.log("Klikam w link CONTACT");                         //TO SAMO NIZEJ tylko nizej po stworzeniu metody
		//driver.findElement(By.linkText("CONTACT")).click();       //klikniecie w link
		linkClick("CONTACT");
		Init.log("Klikam w link SUPPORT");
		driver.findElement(By.linkText("SUPPORT")).click();
		//Init.sleep(5);
		driver.findElement(By.linkText("REGISTER")).click();
		Init.log(driver.getTitle());
		Init.sleep(2);
	}
	@Ignore
		@Test
		public void leftMenu() {
			driver.findElement(By.linkText("Home")).click(); 
			driver.findElement(By.linkText("Flights")).click(); 
			driver.findElement(By.linkText("Hotels")).click(); 
			driver.findElement(By.linkText("Car Rentals")).click(); 
			driver.findElement(By.linkText("Cruises")).click(); 
			driver.findElement(By.linkText("Destinations")).click(); 
			driver.findElement(By.linkText("Vacations")).click(); 
		}
		
		@Test
		public void loginAndReservationLevel() {
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("Gosiek1982");
			driver.findElement(By.name("password")).sendKeys("Gosiek1982");
			driver.findElement(By.name("login")).click();
			
			String oneWayXPath = "/html/body/div/table/tbody/tr/td[2]/table/"
					+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]"
					+ "/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]";       //definiujemy zmienną po xpathu zeby z niej łatwiej korzystać
			driver.findElement(By.xpath(oneWayXPath)).click();    //button
			
			
			//lista wybieralna 1 wersja
			WebElement passCountWebElement = driver.findElement(By.name("passCount"));
			Select passCountSelect = new Select(passCountWebElement);
			passCountSelect.selectByVisibleText("2");
			Init.sleep(2);
			
			//lista wybieralna - druga i łatwiejsza wersja
			//Select fromPortSelect = new Select(driver.findElement(By.name("fromPort"))); //fromPortSelect tworzymy nowego Selecta dla pola fromPort
			//fromPortSelect.selectByVisibleText("Paris");
			//Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));
			//fromMonth.selectByValue("3");
			//Select fromDay = new Select(driver.findElement(By.name("fromDay")));
			//fromDay.selectByValue("15");
			
			
			listaRozwijalnaPoVisibleText("fromPort", "Paris");
			listaRozwijalnaPoValue("fromMonth", "3");
			listaRozwijalnaPoValue("fromDay", "15");
			
			Select toPortSelect = new Select(driver.findElement(By.name("toPort")));
			toPortSelect.selectByVisibleText("Sydney");
			Select toMonth = new Select(driver.findElement(By.name("toMonth")));
			toMonth.selectByValue("3");
			Select toDay = new Select(driver.findElement(By.name("toDay")));
			toDay.selectByValue("18");
			
			//String ServiceClassXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]"
				//	+ "/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table"
				//	+ "/tbody/tr[9]/td[2]/font/font/input[1]";
			// driver.findElement(By.xpath(ServiceClassXPath)).click();
			//Init.sleep(2);
			
			String eco = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
					+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input";
			
			String biz = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
					+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]";
			
			String fir = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
					+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]";
			
			radioClick(fir);
			radioClick(biz);
			radioClick(eco);
			radioClick(fir);
			
			Init.sleep(5);
			
			
			listaRozwijalnaPoVisibleText("airline", "Blue Skies Airlines");
			
			driver.findElement(By.name("findFlights")).click();
			Init.sleep(4);
			
			String departPort = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
					+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input";
			
			radioClick(departPort);
			
			//Select AirlineSelect = new Select(driver.findElement(By.name("airline")));
			//AirlineSelect.selectByVisibleText("Blue Skies Airlines");
			//Init.sleep(2);
			
			String returnPort = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/"
					+ "tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input";
			
			radioClick(returnPort);
			
			driver.findElement(By.name("reserveFlights")).click();
			
			
			
			
			
		}
	
	@After    //after each test
	public void awter() {
		Init.close();
		// tu trzeba zamknąć przeglądarkę
	}
}
