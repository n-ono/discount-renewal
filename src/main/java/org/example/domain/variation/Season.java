package org.example.domain.variation;

import java.time.Month;
import java.time.MonthDay;
import org.example.domain.core.Amount;
import org.example.domain.core.DepartureMonthDay;

/**
 * 季節
 */
public sealed interface Season permits Season.Regular, Season.OffPeak, Season.Peak {

  /**
   * 通常期
   */
  record Regular() implements Season {

    public static final VariationAmount value = new SeasonalVariationAmount(Amount.from(0));
  }

  /**
   * 閑散期 ( 1/16 - 1/30 )
   */
  record OffPeak() implements Season {

    public static final VariationAmount value = new SeasonalVariationAmount(Amount.from(-200));

    /**
     * 出発日が閑散期に含まれるかを判定する
     *
     * @param departureMonthDay 出発日
     * @return 判定結果
     */
    public static boolean include(DepartureMonthDay departureMonthDay) {
      return !(MonthDay.of(Month.JANUARY, 16).isAfter(departureMonthDay.value()) || MonthDay.of(
          Month.JANUARY, 30).isBefore(departureMonthDay.value()));
    }
  }

  /**
   * 繁忙期 ( 12/25 - 1/10 )
   */
  record Peak() implements Season {

    public static final VariationAmount value = new SeasonalVariationAmount(Amount.from(200));

    /**
     * 出発日が繁忙期に含まれるか判定する
     *
     * @param departureMonthDay 出発日
     * @return 判定結果
     */
    public static boolean include(DepartureMonthDay departureMonthDay) {
      return !(MonthDay.of(Month.DECEMBER, 25).isAfter(departureMonthDay.value()) && MonthDay.of(
          Month.JANUARY, 10).isBefore(departureMonthDay.value()));
    }
  }
}
