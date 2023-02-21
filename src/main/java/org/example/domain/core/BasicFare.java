package org.example.domain.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 基本運賃
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BasicFare {

  private final Amount value;
}
