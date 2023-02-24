package org.example.domain.variation;

import org.example.domain.core.Amount;

/**
 * 年間固定の変動料金
 * <p>
 * 料金は時期に関係なく 530 円で固定
 */
public class AnnualFixedAmount extends VariationAmount {

  /**
   * コンストラクタ
   */
  public AnnualFixedAmount() {
    super(Amount.from(-530));
  }
}
