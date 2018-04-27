package com.element34.testng.listeners;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestNGMethod;
import org.testng.internal.WrappedTestNGMethod;

public class Metadata {

  private static final Logger logger = LoggerFactory.getLogger(Metadata.class);
  private static final Map<ITestNGMethod, Metadata> map = new IdentityHashMap<>();
  private final Map<String, Object> metadata = new HashMap<>();

  private Metadata() {

  }

  public static synchronized Metadata getMetadata(ITestNGMethod method) {
    if (method instanceof WrappedTestNGMethod) {
      method = unwrapp((WrappedTestNGMethod) method);
    }
    Metadata res = map.get(method);
    if (res == null) {
      res = new Metadata();
      map.put(method, res);
    }
    return res;
  }

  private static ITestNGMethod unwrapp(WrappedTestNGMethod method) {
    try {
      Field f = method.getClass().getDeclaredField("testNGMethod");
      f.setAccessible(true);
      return (ITestNGMethod) f.get(method);
    } catch (Exception e) {
      return null;
    }
  }

  /*public static synchronized Metadata getMetadata(IInvokedMethod method) {
    Metadata res = map.get(method.getTestMethod());
    if (res == null) {
      res = new Metadata();
      map.put(method.getTestMethod(), res);
    }
    return res;
  }*/

  public static void count() {
    System.out.println("count : " + map.keySet().size());
  }

  public Metadata put(String key, Object object) {
    metadata.put(key, object);
    return this;
  }

//  public JsonObject asJson() {
//    JsonObject o = new JsonObject();
//    for (String key : metadata.keySet()) {
//      o.addProperty(key, metadata.get(key).toString());
//    }
//    return o;
//  }

  public Object get(String key) {
    return metadata.get(key);
  }
}
