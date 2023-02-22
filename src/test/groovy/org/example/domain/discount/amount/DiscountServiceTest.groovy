package org.example.domain.discount.amount

import org.example.domain.core.*
import org.example.domain.discount.group.GroupFactory
import org.example.domain.fare.Fare
import org.example.domain.super_express_surcharge.SuperExpressSurcharge
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Month
import java.time.MonthDay

import static org.example.domain.core.Goods.SeatType.NonReserved
import static org.example.domain.core.Goods.SeatType.Reserved
import static org.example.domain.core.Goods.TripType.OneWay
import static org.example.domain.core.Goods.TripType.Round

@Unroll
class DiscountServiceTest extends Specification {

    private def service = new DiscountService()

    def "applyFare - #description"() {
        expect:
        service.apply(basicFare, tripType, businessKilometer, group, departureMonthDay) == expected

        where:
        basicFare                         | tripType | businessKilometer          | group                     | departureMonthDay                                      | expected                     || description
        new BasicFare(Amount.from(8910))  | OneWay   | new BusinessKilometer(553) | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.SEPTEMBER, 4)) | new Fare(Amount.from(8910))  || "団体割引 10% 適用期間外に大人 1 人で新大阪まで片道旅行する"
        new BasicFare(Amount.from(8910))  | OneWay   | new BusinessKilometer(553) | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 21)) | new Fare(Amount.from(8910))  || "団体割引 10% 適用期間に大人 1 人で新大阪まで片道旅行する"
        new BasicFare(Amount.from(8910))  | Round    | new BusinessKilometer(553) | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.SEPTEMBER, 4)) | new Fare(Amount.from(8910))  || "団体割引 10% 適用期間外に大人 1 人で新大阪まで往復旅行する"
        new BasicFare(Amount.from(10010)) | OneWay   | new BusinessKilometer(644) | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.SEPTEMBER, 4)) | new Fare(Amount.from(10010)) || "団体割引 10% 適用期間外に大人 1 人で姫路まで片道旅行する"
        new BasicFare(Amount.from(10010)) | Round    | new BusinessKilometer(644) | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.SEPTEMBER, 4)) | new Fare(Amount.from(9000))  || "団体割引 10% 適用期間外に大人 1 人で姫路まで往復旅行する"
        new BasicFare(Amount.from(8910))  | OneWay   | new BusinessKilometer(553) | GroupFactory.create(4, 4) | new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 21)) | new Fare(Amount.from(8010))  || "団体割引 10% 適用期間に総勢 8 人で新大阪まで片道旅行する"
        new BasicFare(Amount.from(8910))  | OneWay   | new BusinessKilometer(553) | GroupFactory.create(4, 4) | new DepartureMonthDay(MonthDay.of(Month.SEPTEMBER, 4)) | new Fare(Amount.from(7570))  || "団体割引 10% 適用期間外に総勢 8 人で新大阪まで片道旅行する"
    }

    def "applySuperExpressSurcharge - #description"() {
        expect:
        service.apply(basicSuperExpressSurcharge, seatType, group, departureMonthDay) == expected

        where:
        basicSuperExpressSurcharge                        | seatType    | group                     | departureMonthDay                                      | expected                                     || description
        new BasicSuperExpressSurcharge(Amount.from(5490)) | Reserved    | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.OCTOBER, 30))  | new SuperExpressSurcharge(Amount.from(5490)) || "通常期に大人 1 人がひかり指定席で姫路まで旅行する"
        new BasicSuperExpressSurcharge(Amount.from(5490)) | Reserved    | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 25)) | new SuperExpressSurcharge(Amount.from(5690)) || "繁忙期に大人 1 人がひかり指定席で姫路まで旅行する"
        new BasicSuperExpressSurcharge(Amount.from(5490)) | Reserved    | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.JANUARY, 30))  | new SuperExpressSurcharge(Amount.from(5290)) || "閑散期に大人 1 人がひかり指定席で姫路まで旅行する"
        new BasicSuperExpressSurcharge(Amount.from(5490)) | NonReserved | GroupFactory.create(1, 0) | new DepartureMonthDay(MonthDay.of(Month.JANUARY, 30))  | new SuperExpressSurcharge(Amount.from(4960)) || "閑散期に大人 1 人がひかり自由席で姫路まで旅行する"
    }
}
