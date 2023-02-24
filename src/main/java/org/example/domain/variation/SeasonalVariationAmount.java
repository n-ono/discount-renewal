package org.example.domain.variation;

import org.example.domain.core.Amount;

/**
 * 季節の変動料金
 */
public class SeasonalVariationAmount extends VariationAmount {

  /**
   * コンストラクタ
   *
   * @param amount 料金
   */
  public SeasonalVariationAmount(Amount amount) {
    super(amount);
  }
}
