package com.ifengxue.captcha;

import java.util.concurrent.TimeUnit;

public abstract class AbstractCaptcha<S, V, C, E> implements Captcha<S, V, C, E> {

  protected TimeUnit timeUnit = DEFAULT_TIME_UNIT;
  protected long validPeriod = UNLIMITED;
  protected long nextSendFreezeTime = UNLIMITED;

  @Override
  public CaptchaConfigurable setTimeUnit(TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
    return this;
  }

  @Override
  public CaptchaConfigurable setValidPeriod(long validPeriod) {
    this.validPeriod = validPeriod;
    return this;
  }

  @Override
  public CaptchaConfigurable setNextSendFreezeTime(long nextSendFreezeTime) {
    this.nextSendFreezeTime = nextSendFreezeTime;
    return this;
  }
}
