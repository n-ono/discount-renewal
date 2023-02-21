package org.example.domain.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 営業キロ
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BusinessKilometer {

  private final int value;

  /**
   * 割引対象か判定する
   *
   * @return 判定結果
   */
  public boolean isDiscountable() {
    return 601 <= value;
  }
}
