package com.ifengxue.captcha.generator;

public interface CaptchaMessageGenerator<C, E> {

  /**
   * 生成验证码字符串
   *
   * @param c 验证码 {@link CaptchaGenerator#generate(Object)}
   * @param e environment
   * @return 验证码信息
   */
  C generate(C c, E e);
}
