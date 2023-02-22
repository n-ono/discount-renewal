package org.example.domain.variation;

import org.example.domain.core.DepartureMonthDay;
import org.example.domain.core.Goods.SeatType;

/**
 * 変動料金ファクトリ
 */
public class VariationAmountFactory {

  /**
   * 座席区分と出発日から変動料金を算出する
   *
   * @param seatType          座席区分
   * @param departureMonthDay 出発日
   * @return 変動料金
   */
  public static VariationAmount create(SeatType seatType, DepartureMonthDay departureMonthDay) {
    return switch (seatType) {
      case NonReserved -> new AnnualFixedAmount();
      case Reserved -> {
        if (Season.OffPeak.include(departureMonthDay)) {
          yield Season.OffPeak.value;
        } else if (Season.Peak.include(departureMonthDay)) {
          yield Season.Peak.value;
        } else {
          yield Season.Regular.value;
        }
      }
    };
  }
}
