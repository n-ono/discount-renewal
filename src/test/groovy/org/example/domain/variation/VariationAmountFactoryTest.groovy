package org.example.domain.variation

import org.example.domain.core.Amount
import org.example.domain.core.DepartureMonthDay
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Month
import java.time.MonthDay

import static org.example.domain.core.Goods.SeatType.NonReserved
import static org.example.domain.core.Goods.SeatType.Reserved

@Unroll
class VariationAmountFactoryTest extends Specification {

    def "create - #description"() {
        expect:
        VariationAmountFactory.create(seatType, departureMonthDay) == expected

        where:
        seatType    | departureMonthDay                                      | expected                                       || description
        NonReserved | new DepartureMonthDay(MonthDay.of(Month.SEPTEMBER, 4)) | new AnnualFixedAmount()                        || "時期関係なく自由席は固定"
        Reserved    | new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 25)) | new SeasonalVariationAmount(Amount.from(200))  || "繁忙期の指定席は +200 円"
        Reserved    | new DepartureMonthDay(MonthDay.of(Month.JANUARY, 10))  | new SeasonalVariationAmount(Amount.from(200))  || "繁忙期の指定席は +200 円"
        Reserved    | new DepartureMonthDay(MonthDay.of(Month.JANUARY, 16))  | new SeasonalVariationAmount(Amount.from(-200)) || "閑散期の指定席は -200 円"
        Reserved    | new DepartureMonthDay(MonthDay.of(Month.JANUARY, 30))  | new SeasonalVariationAmount(Amount.from(-200)) || "閑散期の指定席は -200 円"
    }
}
