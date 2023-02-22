package org.example.domain.discount.amount;

import org.example.domain.core.BasicFare;
import org.example.domain.core.BasicSuperExpressSurcharge;
import org.example.domain.core.BusinessKilometer;
import org.example.domain.core.DepartureMonthDay;
import org.example.domain.core.Goods.SeatType;
import org.example.domain.core.Goods.TripType;
import org.example.domain.discount.factory.GroupDiscountPercentageFactory;
import org.example.domain.discount.factory.RoundTripDiscountPercentageFactory;
import org.example.domain.discount.group.Group;
import org.example.domain.fare.Fare;
import org.example.domain.super_express_surcharge.SuperExpressSurcharge;
import org.example.domain.variation.VariationAmountFactory;

/**
 * 割引サービス
 */
public class DiscountService {

  /**
   * 割引は 往復割引 → 団体割引 の順序で適用する
   *
   * @param basicFare         基本運賃
   * @param tripType          旅行区分
   * @param businessKilometer 営業キロ
   * @param group             団体
   * @param departureMonthDay 出発日
   * @return 運賃
   */
  public Fare apply(BasicFare basicFare, TripType tripType, BusinessKilometer businessKilometer,
      Group group, DepartureMonthDay departureMonthDay) {
    return basicFare.startDiscount()
        .discounted(RoundTripDiscountPercentageFactory.create(tripType, businessKilometer))
        .discounted(GroupDiscountPercentageFactory.create(group, departureMonthDay)).endDiscount();
  }

  /**
   * 割引は変動料金を調整した後に適用する
   *
   * @param basicSuperExpressSurcharge 基本特急料金
   * @param seatType                   座席区分
   * @param group                      団体
   * @param departureMonthDay          出発日
   * @return 特急料金
   */
  public SuperExpressSurcharge apply(BasicSuperExpressSurcharge basicSuperExpressSurcharge,
      SeatType seatType, Group group, DepartureMonthDay departureMonthDay) {
    return basicSuperExpressSurcharge.adjust(
            VariationAmountFactory.create(seatType, departureMonthDay)).startDiscount()
        .discounted(GroupDiscountPercentageFactory.create(group, departureMonthDay)).endDiscount();
  }
}
