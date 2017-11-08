package com.ifengxue.captcha;

/**
 * 验证码接口
 *
 * @param <S> 发送结果
 * @param <V> 验证结果
 * @param <E> environment
 * @param <C> captcha
 */
public interface Captcha<S, V, C, E> extends CaptchaConfigurable<C, S, E> {

  /**
   * 发送验证码
   *
   * @param to 验证码接收者
   * @return 发送结果
   */
  default S send(String to) {
    return send(to, Context.getDefaultInstance());
  }

  /**
   * 发送验证码
   *
   * @param to 验证码接受者
   * @param context 发送上下文
   * @return 发送结果
   */
  S send(String to, Context context);

  /**
   * 验证验证码
   *
   * @param to 验证码接受者
   * @param captcha 验证码
   * @return 验证结果
   */
  default V check(String to, String captcha) {
    return check(to, captcha, Context.getDefaultInstance());
  }

  /**
   * 验证验证码
   *
   * @param to 验证码接受者
   * @param captcha 验证码
   * @param context 验证上下文
   * @return 验证结果
   */
  V check(String to, String captcha, Context context);
}
