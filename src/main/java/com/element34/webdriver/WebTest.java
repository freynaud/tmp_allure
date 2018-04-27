package com.element34.webdriver;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target({METHOD})
public @interface WebTest {

  BrowserSet browsers() default BrowserSet.Chrome;

  boolean video() default false;
}
