package org.example;

import java.time.Month;
import java.time.MonthDay;
import org.example.domain.core.Amount;
import org.example.domain.core.BasicFare;
import org.example.domain.core.BasicSuperExpressSurcharge;
import org.example.domain.core.BusinessKilometer;
import org.example.domain.core.DepartureMonthDay;
import org.example.domain.core.Goods.SeatType;
import org.example.domain.core.Goods.TripType;
import org.example.domain.discount.amount.DiscountService;
import org.example.domain.discount.group.Group;
import org.example.domain.discount.group.GroupFactory;
import org.example.domain.fare.Fare;
import org.example.domain.price.Price;
import org.example.domain.super_express_surcharge.SuperExpressSurcharge;

public class Main {

  public static void main(String[] args) {
    // 指定席のひかりで新大阪まで大人 2 人と子供 1 人で往復旅行する
    // パラメータの準備
    BasicFare basicFare = new BasicFare(Amount.from(8910));
    BasicSuperExpressSurcharge basicSuperExpressSurcharge = new BasicSuperExpressSurcharge(
        Amount.from(5490));
    TripType tripType = TripType.Round;
    DepartureMonthDay departureMonthDay = new DepartureMonthDay(MonthDay.of(Month.FEBRUARY, 23));
    BusinessKilometer businessKilometer = new BusinessKilometer(553);
    Group group = GroupFactory.create(2, 1);

    // 運賃と特急料金から料金を計算する
    Fare fare = new DiscountService().apply(basicFare, tripType, businessKilometer, group,
        departureMonthDay);
    SuperExpressSurcharge superExpressSurcharge = new DiscountService().apply(
        basicSuperExpressSurcharge, SeatType.Reserved, group, departureMonthDay);
    Price price = fare.plus(superExpressSurcharge);

    // 料金
    System.out.println(price.forAdult().getValue() * group.charged().adults());
    System.out.println(price.forChild().getValue() * group.charged().children());
  }
}