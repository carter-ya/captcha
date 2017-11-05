package com.ifengxue.captcha.sender;

/**
 * 验证码发送者
 *
 * @param <S> 发送结果
 */
public interface CaptchaSender<S, E> {

  /**
   * 发送验证码
   *
   * @param to 验证码接受者
   * @param e environment
   * @return 发送结果
   */
  S send(String to, E e);
}
