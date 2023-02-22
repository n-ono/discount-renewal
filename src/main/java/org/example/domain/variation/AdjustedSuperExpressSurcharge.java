package org.example.domain.variation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.core.Amount;
import org.example.domain.discount.amount.CalculatingSuperExpressSurcharge;

/**
 * 季節の変動料金を調整した特急料金
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class AdjustedSuperExpressSurcharge {

  private final Amount value;

  /**
   * 計算途中の特急料金を返す
   *
   * @return 計算途中の特急料金
   */
  public CalculatingSuperExpressSurcharge startDiscount() {
    return new CalculatingSuperExpressSurcharge(value);
  }
}
