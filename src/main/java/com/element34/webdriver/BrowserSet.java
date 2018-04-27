package com.element34.webdriver;

public enum BrowserSet {
  Chrome(new String[]{"chrome"}),

  IE(new String[]{"internet explorer"}),
  FF(new String[]{"firefox"}),
  Dev(new String[]{"chrome", "firefox"}),
  Web(new String[]{"chrome", "firefox", "internet explorer"}),

  Regression(new String[]{"chrome", "firefox", "internet explorer","android"});
  private final String[] browsers;

  BrowserSet(String[] browsers) {
    this.browsers = browsers;
  }

  public String[] browsers() {
    return browsers;
  }
}
