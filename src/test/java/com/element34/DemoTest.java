package com.element34;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DemoTest {

  private final String browser;
  private final Logger logger = LoggerFactory.getLogger(DemoTest.class);

  public DemoTest(String browser) {
    this.browser = browser;
  }

//  @Factory
//  public Object[] factoryMethod() {
//    return new Object[]{
//        new DemoTest("firefox"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//        new DemoTest("chrome"),
//    };
//  }

  @DataProvider(name = "data")
  public Object[][] data() {
    return new Object[][]{
        {"url1"},
        {"url2"}
    };
  }

  @Test(/*retryAnalyzer = RetryAnalyser.class,*/dataProvider = "data")
  //@WebTest(browsers = Web)
  @E34Epic(name = "Home page redisign")
  public void browser(String url) throws Exception {
//    Thread.sleep(new Random().nextInt(5000));
    //String browser = Context.browser.get();
    logger.info("browser:" + browser);
    if ("chrome".equals(browser)) {
//     throw new Exception("Houlala, it's chrome");
      Assert.assertNotEquals(browser, "chrome");
    }

    throw new Exception("test");
  }

//
//  @Feature("my feature")
//  @Story("Page title should be FED like")
//  @Test(expectedExceptions = Exception.class)
//  public void failed() throws Exception {
//    // throw new Exception("woot");
//  }
//
//  @Feature("my feature2")
//  @Story("Page title should be FED like2")
//  @Test
//  public void passed() throws Exception {
//    throw new Exception("woot");
//  }
}
