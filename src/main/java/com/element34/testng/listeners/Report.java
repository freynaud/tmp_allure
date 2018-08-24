package com.element34.testng.listeners;

import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.xml.XmlSuite;

public class Report implements IReporter {

  @Override
  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    for (ISuite suite : suites){
      Map<String, ISuiteResult> suiteResultMap = suite.getResults();
      for (String key : suiteResultMap.keySet()){
          ISuiteResult sresult = suiteResultMap.get(key);
        System.out.println("passed:"+sresult.getTestContext().getPassedTests().getAllResults().size());
        System.out.println("failed"+sresult.getTestContext().getFailedTests().getAllResults().size());
        System.out.println("skipped"+sresult.getTestContext().getSkippedTests().getAllResults().size());
      }
    }
  }
}
