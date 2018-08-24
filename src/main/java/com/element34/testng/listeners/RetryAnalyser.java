package com.element34.testng.listeners;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {


  Object previous;
  private final Logger logger = LoggerFactory.getLogger(RetryAnalyser.class);


  @Override
  public boolean retry(ITestResult result) {
    if (result.isSuccess()) {
      return false;
    }
    if (result.getThrowable() instanceof AssertionError) {

      List<ITestResult> results = RetryCache.RETRY_CACHE.getOrDefault(result.getInstance(), new ArrayList<>());
      results.add(result);
      RetryCache.RETRY_CACHE.put(result.getInstance(),results );
      logger.warn("Retrying(" + results.size() + ") : " + result.getThrowable().getMessage());
      previous = result.getInstance();
      return results.size()<3;
    }
    return false;
  }
}
