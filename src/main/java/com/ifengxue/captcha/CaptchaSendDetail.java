package com.ifengxue.captcha;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 验证码发送详情
 *
 * @author LiuKeFeng
 * @date 2017-11-08
 */
public class CaptchaSendDetail implements Context {

  /**
   * 验证码
   */
  private String captcha;
  /**
   * 验证码有效期，-1永久有效
   */
  private long validPeriod;
  /**
   * 验证码是否有效
   */
  private boolean valid;
  /**
   * 验证码被检查出错误的次数
   */
  private int checkErrorTimes;
  /**
   * 验证码发送时间
   */
  private LocalDateTime sendTime;
  private Map<String, Object> context = new HashMap<>();

  @Override
  public <T> Context put(String key, T value) {
    return this;
  }

  @Override
  public boolean containsKey(String key) {
    return false;
  }

  @Override
  public <T> T get(String key) {
    return null;
  }

  @Override
  public Set<String> keySet() {
    return null;
  }

  @Override
  public Context clear() {
    return null;
  }
}
