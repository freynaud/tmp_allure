package com.element34.testng.listeners;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.WrappedTestNGMethod;

public class DriverBinder implements IInvokedMethodListener2 {

  private final Logger logger = LoggerFactory.getLogger(DriverBinder.class);

  public void beforeInvocation(IInvokedMethod method, ITestResult result, ITestContext context) {

    ITestNGMethod m = result.getMethod();
    String browser = "UNKNOWN";
    if (m instanceof WrappedTestNGMethod) {
      browser = (String) Metadata.getMetadata(m).get("browser");
      System.out.println("browser for wrapped " + browser);
    } else {
      browser = (String) Metadata.getMetadata(m).get("browser");
      System.out.println("browser for not wrapped " + browser);
    }
    logger.info("beforeInvocation " + browser);
    Context.browser.set(browser);
  }

  public void afterInvocation(IInvokedMethod method, ITestResult iTestResult, ITestContext iTestContext) {

    Context.browser.remove();
  }

  public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    //no op
  }

  public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    //no op
  }
}
