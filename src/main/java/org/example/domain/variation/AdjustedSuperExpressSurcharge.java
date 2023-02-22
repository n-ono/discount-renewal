package org.example.domain.variation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.domain.core.Amount;

/**
 * 季節の変動料金を調整した特急料金
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class AdjustedSuperExpressSurcharge {

  private final Amount value;
}
