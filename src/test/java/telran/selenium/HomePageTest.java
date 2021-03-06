package telran.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import telran.selenium.LogLog4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import telran.selenium.pages.HomePageHelper;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends TestBase {

  private HomePageHelper homepage;
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


  @BeforeMethod
  public void initPageObjects() {

    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  // ---this test verifies that all elements on HomePage screen in Russian ---
  @Test
  public void allElemetsInRussian() {

    Log.info("---- Test allElementsInRussian is executed -----");
    homepage.clickLangRussian();
    Log.info("User presses Russian language button");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    Log.info("Timeout - wait 30 sec");
    Assert.assertTrue(homepage.allElementsInRus());
  }

  // --- this test verifies that all elements on HomePage screen in English ---
  @Test
  public void allElemetsInEnglish() {
    //driver.get(baseUrl);
    System.out.println("driver was started");
    homepage.clickLangEnglish();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    homepage.writeTextOfMenuCommands();
    Assert.assertTrue(homepage.allElementsInEng());
  }

  // --- this test verifies that all elements on HomePage screen in Hebrew ---
  @Test
  public void allElemetsInHebrew() {
    //driver.get(baseUrl);
    System.out.println("driver was started");
    homepage.clickLangHebrew();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //homepage.writeTextOfMenuCommands();
    Assert.assertTrue(homepage.allElementsInHebrew());
  }

}
