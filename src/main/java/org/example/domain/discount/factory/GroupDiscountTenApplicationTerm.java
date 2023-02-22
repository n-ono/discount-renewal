package org.example.domain.discount.factory;

import java.time.Month;
import java.time.MonthDay;
import org.example.domain.core.DepartureMonthDay;

/**
 * 団体割引 10% 適用期間
 */
public class GroupDiscountTenApplicationTerm {

  /**
   * 適用開始月日
   */
  private static final MonthDay START_MONTH_DAY = MonthDay.from(MonthDay.of(Month.DECEMBER, 21));

  /**
   * 適用終了月日
   */
  private static final MonthDay END_MONTH_DAY = MonthDay.from(MonthDay.of(Month.JANUARY, 10));

  /**
   * 出発日が団体割引 10% 適用期間に含まれるかを判定する
   *
   * @param departureMonthDay 出発日
   * @return 判定結果
   */
  public static boolean include(DepartureMonthDay departureMonthDay) {
    MonthDay value = departureMonthDay.getValue();
    return !(START_MONTH_DAY.isAfter(value) && END_MONTH_DAY.isBefore(value));
  }
}
