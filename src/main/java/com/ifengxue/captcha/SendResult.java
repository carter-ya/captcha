package com.ifengxue.captcha;

public interface SendResult {

  /**
   * 获取发送状态
   * @return
   */
  SendStatus getSendStatus();

  /**
   * 发送状态
   */
  enum SendStatus {
    SEND_SUCCESS,
    SEND_ERROR,
  }
}
