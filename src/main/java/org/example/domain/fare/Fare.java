package org.example.domain.fare;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.core.Amount;
import org.example.domain.price.Price;
import org.example.domain.super_express_surcharge.SuperExpressSurcharge;

/**
 * 運賃
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Fare {

  private final Amount amount;

  /**
   * 子供運賃を返す
   *
   * @return 子供運賃
   */
  public Amount forChild() {
    return amount.half();
  }

  /**
   * 大人運賃を返す
   *
   * @return 大人運賃
   */
  public Amount forAdult() {
    return amount;
  }

  /**
   * 料金を返す
   *
   * @param superExpressSurcharge 特急料金
   * @return 料金
   */
  public Price plus(SuperExpressSurcharge superExpressSurcharge) {
    return new Price(this, superExpressSurcharge);
  }
}
