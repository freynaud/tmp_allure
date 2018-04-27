package com.element34.testng.listeners;

import com.element34.webdriver.WebTest;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.internal.MethodInstance;


public class TestMultiplexer implements IMethodInterceptor {

  private static boolean ran = false;
  private final Logger logger = LoggerFactory.getLogger(TestMultiplexer.class);

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    if (!ran) {
      ran = true;
      List<IMethodInstance> instances = new ArrayList<>();
      for (IMethodInstance method : methods) {
        instances.addAll(explode(method, context));
      }
      return instances;
    }
    return methods;
  }


  private List<IMethodInstance> explode(IMethodInstance instance, ITestContext context) {
    List<IMethodInstance> instances = new ArrayList<>();

    WebTest webTest = instance.getMethod().getConstructorOrMethod().getMethod().getAnnotation(WebTest.class);
    if (webTest != null) {
      ITestNGMethod original = instance.getMethod();
      String[] browsers = webTest.browsers().browsers();
      for (int i = 0; i < original.getInvocationCount(); i++) {
        for (String browser : browsers) {
          ITestNGMethod clone = original.clone();
          clone.setInvocationCount(1);
          MethodInstance newInstance = new MethodInstance(clone);
          logger.info("setting metadata to " + browser);
          Metadata.getMetadata(clone).put("browser", browser);
          instances.add(newInstance);
        }
      }
    } else {
      instances.add(instance);
    }
    return instances;
  }
}