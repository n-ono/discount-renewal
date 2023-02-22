package org.example.domain.discount.group;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 課金対象の団体
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ChargedGroup {

  @Getter
  private final int adults;

  @Getter
  private final int children;
}
