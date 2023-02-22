package org.example.domain.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.discount.amount.CalculatingFare;

/**
 * 基本運賃
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BasicFare {

  private final Amount value;

  /**
   * 割引を開始する
   *
   * @return 計算途中の運賃
   */
  public CalculatingFare startDiscount() {
    return new CalculatingFare(value);
  }
}
