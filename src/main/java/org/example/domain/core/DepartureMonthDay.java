package org.example.domain.core;

import java.time.MonthDay;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 出発日
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DepartureMonthDay {

  @Getter
  private final MonthDay value;
}
