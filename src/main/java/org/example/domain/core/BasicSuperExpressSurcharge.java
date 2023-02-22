package org.example.domain.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.variation.AdjustedSuperExpressSurcharge;
import org.example.domain.variation.VariationAmount;

/**
 * 基本特急料金
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BasicSuperExpressSurcharge {

  private final Amount value;

  /**
   * 変動料金を調整する
   *
   * @param variationAmount 変動料金
   * @return 調整済み特急料金
   */
  public AdjustedSuperExpressSurcharge adjust(VariationAmount variationAmount) {
    return new AdjustedSuperExpressSurcharge(value.plus(variationAmount.getValue()));
  }
}
