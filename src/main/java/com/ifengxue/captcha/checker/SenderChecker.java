package com.ifengxue.captcha.checker;

public interface SenderChecker<S, E> {

  S check(E e);
}
