package com.ifengxue.captcha;

import com.ifengxue.captcha.checker.SenderChecker;
import com.ifengxue.captcha.generator.CaptchaGenerator;
import com.ifengxue.captcha.sender.CaptchaSender;
import java.util.concurrent.TimeUnit;

public interface CaptchaConfigurable<C, S, E> {

  TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;
  /**
   * 无限期
   */
  long UNLIMITED = -1;

  void setCaptchaGenerator(CaptchaGenerator<C, E> captchaGenerator);

  CaptchaConfigurable setCaptchaSender(CaptchaSender<S, E> sender);

  CaptchaConfigurable addSendChecker(SenderChecker<S, E> checker);

  /**
   * 设置时间单位
   */
  CaptchaConfigurable setTimeUnit(TimeUnit timeUnit);

  /**
   * 设置验证码有效期， -1永久有效
   *
   * @see {{@link #setTimeUnit(TimeUnit)}}
   */
  CaptchaConfigurable setValidPeriod(long validPeriod);

  /**
   * 设置每次发送验证码之间的间隔， -1不间隔
   *
   * @param nextSendFreezeTime 每次发送验证码之间的间隔时间
   * @see {{@link #setTimeUnit(TimeUnit)}}
   */
  CaptchaConfigurable setNextSendFreezeTime(long nextSendFreezeTime);
}
