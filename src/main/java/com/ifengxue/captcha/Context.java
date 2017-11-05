package com.ifengxue.captcha;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 绑定上下文
 */
public interface Context {

  /**
   * 绑定上下文
   *
   * @param key key
   * @param value value
   */
  <T> Context put(String key, T value);

  /**
   * 批量绑定上下文
   */
  default Context putAll(Map<String, Object> context) {
    context.forEach(this::put);
    return this;
  }

  /**
   * 批量绑定上下文
   */
  default Context putAll(Context context) {
    context.keySet().forEach(key -> put(key, context.get(key)));
    return this;
  }

  /**
   * 检查上下文是否包含指定的key
   */
  boolean containsKey(String key);

  /**
   * 从上下文获取绑定的值
   */
  <T> T get(String key);

  /**
   * 从上下文获取绑定的值，如果没绑定则返回默认值
   */
  @SuppressWarnings("unchecked")
  default <T> T getOrDefault(String key, T defValue) {
    if (containsKey(key)) {
      return get(key);
    } else {
      return defValue;
    }
  }

  /**
   * 返回key视图
   */
  Set<String> keySet();

  /**
   * 清除绑定的上下文参数
   */
  Context clear();

  /**
   * 获取默认的上下文实例
   */
  static Context getDefaultInstance() {
    return new InnerContext();
  }

  class InnerContext implements Context {

    private Map<String, Object> innerMap = new HashMap<>();

    @Override
    public <T> Context put(String key, T value) {
      innerMap.put(key, value);
      return this;
    }

    @Override
    public boolean containsKey(String key) {
      return innerMap.containsKey(key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
      return (T) innerMap.get(key);
    }

    @Override
    public Set<String> keySet() {
      return innerMap.keySet();
    }

    @Override
    public Context clear() {
      innerMap.clear();
      return this;
    }
  }
}
