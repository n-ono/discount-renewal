package org.example.domain.discount.factory;

import org.example.domain.core.BusinessKilometer;
import org.example.domain.core.Goods.TripType;

/**
 * 往復旅行割引率ファクトリ
 */
public class RoundTripDiscountPercentageFactory {

  /**
   * 旅行区分と営業キロから割引を算出する
   *
   * @param tripType          旅行区分
   * @param businessKilometer 営業キロ
   * @return 適用される往復旅行割引率
   */
  public static Percentage create(TripType tripType, BusinessKilometer businessKilometer) {
    return switch (tripType) {
      case OneWay -> Percentage.zero();
      case Round -> {
        if (businessKilometer.isDiscountable()) {
          yield Percentage.ten();
        } else {
          yield Percentage.zero();
        }
      }
    };
  }
}
