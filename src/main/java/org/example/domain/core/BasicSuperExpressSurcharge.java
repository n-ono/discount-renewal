package org.example.domain.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 基本特急料金
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BasicSuperExpressSurcharge {

  private final Amount value;
}
