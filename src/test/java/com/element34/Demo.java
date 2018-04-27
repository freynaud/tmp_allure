package com.element34;


import static com.element34.webdriver.BrowserSet.Regression;

import com.element34.testng.listeners.Context;
import com.element34.testng.listeners.RetryAnalyser;
import com.element34.webdriver.WebTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Demo {

  private final Logger logger = LoggerFactory.getLogger(Demo.class);


  @Test(retryAnalyzer = RetryAnalyser.class)
  @WebTest(browsers = Regression)
  public void browser() throws Exception {
    String browser = Context.browser.get();
       logger.info("browser:"+browser);
    if ("chrome".equals(browser)) {
     throw new Exception("Houlala, it's chrome");
    }
  }
}
