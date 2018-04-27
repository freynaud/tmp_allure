package com.element34.testng.listeners;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import org.testng.ITestResult;

public class RetryCache {

  public static final Map<Object, List<ITestResult>> RETRY_CACHE = new IdentityHashMap<>();
}
