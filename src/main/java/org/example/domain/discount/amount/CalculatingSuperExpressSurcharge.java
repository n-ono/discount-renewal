package org.example.domain.discount.amount;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.core.Amount;
import org.example.domain.discount.factory.Percentage;
import org.example.domain.super_express_surcharge.SuperExpressSurcharge;

/**
 * 計算途中の特急料金
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CalculatingSuperExpressSurcharge {

  private final Amount value;

  /**
   * 指定した割引率を割引いた特急料金
   *
   * @param percentage 割引率
   * @return 計算途中の特急料金
   */
  public CalculatingSuperExpressSurcharge discounted(Percentage percentage) {
    return new CalculatingSuperExpressSurcharge(value.percentageOf(percentage.rest()));
  }

  /**
   * 割引を終了する
   *
   * @return 特急料金
   */
  public SuperExpressSurcharge endDiscount() {
    return new SuperExpressSurcharge(value);
  }
}
