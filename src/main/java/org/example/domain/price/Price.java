package org.example.domain.price;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.core.Amount;
import org.example.domain.fare.Fare;
import org.example.domain.super_express_surcharge.SuperExpressSurcharge;

/**
 * 料金
 * <p>
 * 子供料金の計算式は ( 運賃 + 特急料金 ) * 0.5 ではなくて 運賃 * 0.5 + 特急料金 * 0.5 なので、運賃と特急料金をフィールドに持つ設計にした
 * <p>
 * 例えばひかり ( 指定席 ) で新大阪まで旅行する際の子供料金を前者の計算式で計算すると 7200 円になるが、正しくは 7190 円になる
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Price {

  private final Fare fare;

  private final SuperExpressSurcharge superExpressSurcharge;

  /**
   * 子供料金を返す
   *
   * @return 子供料金
   */
  public Amount forChild() {
    return fare.forChild().plus(superExpressSurcharge.forChild());
  }

  /**
   * 大人料金を返す
   *
   * @return 大人料金
   */
  public Amount forAdult() {
    return fare.forAdult().plus(superExpressSurcharge.forAdult());
  }
}
