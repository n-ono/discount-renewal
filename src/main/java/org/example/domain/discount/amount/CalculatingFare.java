package org.example.domain.discount.amount;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.core.Amount;
import org.example.domain.discount.factory.Percentage;
import org.example.domain.fare.Fare;

/**
 * 計算途中の運賃
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CalculatingFare {

  private final Amount value;

  /**
   * 指定した割引率を割引いた料金
   *
   * @param percentage 割引率
   * @return 計算途中の運賃
   */
  public CalculatingFare discounted(Percentage percentage) {
    return new CalculatingFare(value.percentageOf(percentage.rest()));
  }

  /**
   * 割引を終了する
   *
   * @return 運賃
   */
  public Fare endDiscount() {
    return new Fare(value);
  }
}
