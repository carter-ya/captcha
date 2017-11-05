package com.ifengxue.captcha.generator;

import com.ifengxue.captcha.RandomUtil;

public class DefaultStringCaptchaGenerator<Object> implements StringCaptchaGenerator<Object> {

  private final int length;
  private final boolean containsLetter;
  private final boolean letterUpper;
  private final boolean containsNumber;

  public DefaultStringCaptchaGenerator() {
    this(DEFAULT_CAPTCHA_LENGTH);
  }

  public DefaultStringCaptchaGenerator(int length) {
    this(length, false, false, true);
  }

  public DefaultStringCaptchaGenerator(int length, boolean containsLetter, boolean letterUpper,
      boolean containsNumber) {
    this.length = length;
    this.containsLetter = containsLetter;
    this.letterUpper = letterUpper;
    this.containsNumber = containsNumber;
  }

  @Override
  public String generate(Object object) {
    return RandomUtil.randomString(length, containsNumber, containsLetter, letterUpper);
  }
}
