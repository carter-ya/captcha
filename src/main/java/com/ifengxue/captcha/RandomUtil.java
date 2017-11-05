package com.ifengxue.captcha;

import java.util.Random;

/**
 * 随机生成验证码
 */
public final class RandomUtil {

  /**
   * 去除了所有干扰字符后的字符数组
   */
  private static final char[] CHARACTERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
      'b', 'c', 'd',
      'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
      'z',};

  private RandomUtil() {
    throw new Error(RandomUtil.class.getSimpleName() + "不能被实例化");
  }

  /**
   * 随机生成数字
   *
   * @param strLength 生成字符串长度
   */
  public static String randomNumberString(int strLength) {
    if (strLength <= 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();
    for (int i = 0; i < strLength; i++) {
      sb.append(rand.nextInt(10));
    }
    return sb.toString();
  }

  /**
   * 随机生成字母
   *
   * @param strLength 生成字符串长度
   * @param containsUpperLetter true:含有大写字母;false:只有小写字母
   */
  public static String randomLetterString(int strLength, boolean containsUpperLetter) {
    if (strLength <= 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();
    while (sb.length() < strLength) {
      int index = rand.nextInt(CHARACTERS.length);
      char ch = CHARACTERS[index];
      if (ch >= 'a') {
        if (containsUpperLetter) {
          sb.append(rand.nextInt(CHARACTERS.length) % 2 == 0 ? ch : (char) (ch - 32));// 随机大小写
        } else {
          sb.append(ch);
        }
      }
    }
    return sb.toString();
  }

  /**
   * 随机生成数字或字母或数字字母的组合
   *
   * @param strLength 生成字符串的长度
   * @param containsNumber 是否生成数字
   * @param containsLetter 是否生成字母
   * @param containsUpperLetter 是否生成大写字母,<code>containsLetter</code>必须设置为true才起效
   */
  public static String randomString(int strLength, boolean containsNumber, boolean containsLetter,
      boolean containsUpperLetter) {
    if ((!containsNumber && !containsLetter) || strLength <= 0) {
      return "";
    }
    // 只需要数字
    if (containsNumber && !containsLetter) {
      return randomNumberString(strLength);
    }
    // 只需要字母
    if (!containsNumber) {
      return randomLetterString(strLength, containsUpperLetter);
    }
    // 数字字母都需要
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();
    for (int i = 0; i < strLength; i++) {
      int index = rand.nextInt(CHARACTERS.length);
      char ch = CHARACTERS[index];
      if (ch >= 'a') {
        if (containsUpperLetter) {
          sb.append(rand.nextInt(CHARACTERS.length) % 2 == 0 ? ch : (char) (ch - 32));// 随机大小写
        } else {
          sb.append(ch);
        }
      } else {// 只是数字
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}