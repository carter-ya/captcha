package com.ifengxue.captcha.generator;

public interface CaptchaGenerator<C, E> {
  int DEFAULT_CAPTCHA_LENGTH = 6;
  /**
   * 验证码生成
   *
   * @param e environment
   * @return 验证码
   */
  C generate(E e);
}
