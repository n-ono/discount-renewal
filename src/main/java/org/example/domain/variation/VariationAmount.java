package org.example.domain.variation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.example.domain.core.Amount;

/**
 * 変動料金
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class VariationAmount {

  @Getter
  protected final Amount value;
}
