package org.example.domain.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 料金
 * <p>
 * 10 円未満は切り捨てる
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Amount {

  @Getter
  private final int value;

  /**
   * コンストラクタ
   *
   * @param value 値
   * @return
   */
  public static Amount from(int value) {
    return new Amount(adjust(value));
  }

  /**
   * 加算する
   *
   * @param other 加数
   * @return 加算した料金
   */
  public Amount plus(Amount other) {
    return new Amount(value + other.value);
  }

  /**
   * 半額にする
   *
   * @return 半額料金
   */
  public Amount half() {
    return new Amount(adjust(value / 2));
  }

  /**
   * 10 円未満は切り捨てる調整をする
   *
   * @param value 値
   * @return 10 円未満を切り捨てた値
   */
  private static int adjust(int value) {
    return (int) Math.floor(value / 10) * 10;
  }
}
