package org.example.domain.discount.factory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引率
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Percentage {

  @Getter
  private final int value;

  public static Percentage zero() {
    return new Percentage(0);
  }

  public static Percentage ten() {
    return new Percentage(10);
  }

  public static Percentage fifteen() {
    return new Percentage(15);
  }
}
