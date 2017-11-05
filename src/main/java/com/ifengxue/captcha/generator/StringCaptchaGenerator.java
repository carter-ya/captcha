package com.ifengxue.captcha.generator;

public interface StringCaptchaGenerator<E> extends CaptchaGenerator<String, E> {

  @Override
  String generate(E e);
}
