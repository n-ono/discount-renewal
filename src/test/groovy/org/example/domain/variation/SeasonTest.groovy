package org.example.domain.variation

import org.example.domain.core.DepartureMonthDay
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Month
import java.time.MonthDay

@Unroll
class SeasonTest extends Specification {

    def "offPeak - #description"() {
        expect:
        Season.OffPeak.include(departureMonthDay) == expected

        where:
        departureMonthDay                                     | expected || description
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 16)) | true     || "閑散期初日"
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 30)) | true     || "閑散期最終日"
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 15)) | false    || "閑散期前日"
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 31)) | false    || "閑散期 1 日後"
    }

    def "peak - #description"() {
        expect:
        Season.Peak.include(departureMonthDay) == expected

        where:
        departureMonthDay                                      | expected || description
        new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 25)) | true     || "繁忙期初日"
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 10))  | true     || "繁忙期最終日"
        new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 24)) | false    || "繁忙期前日"
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 11))  | false    || "繁忙期 1 日後"
    }
}
