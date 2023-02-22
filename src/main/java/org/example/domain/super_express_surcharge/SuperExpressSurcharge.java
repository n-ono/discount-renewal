package org.example.domain.super_express_surcharge;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.core.Amount;

/**
 * 特急料金
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SuperExpressSurcharge {

  private final Amount value;

  /**
   * 子供特急料金を返す
   *
   * @return 子供特急料金
   */
  public Amount forChild() {
    return value.half();
  }

  /**
   * 大人特急料金
   *
   * @return 大人特急料金
   */
  public Amount forAdult() {
    return value;
  }
}
