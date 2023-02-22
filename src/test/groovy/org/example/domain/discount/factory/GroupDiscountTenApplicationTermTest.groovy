package org.example.domain.discount.factory

import org.example.domain.core.DepartureMonthDay
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Month
import java.time.MonthDay

@Unroll
class GroupDiscountTenApplicationTermTest extends Specification {

    def "include - #description"() {
        expect:
        GroupDiscountTenApplicationTerm.include(departureMonthDay) == expected

        where:
        departureMonthDay                                      | expected || description
        new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 21)) | true     || "団体割引 10% 適用期間"
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 10))  | true     || "団体割引 10% 適用期間"
        new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 20)) | false    || "団体割引 10% 適用期間外"
        new DepartureMonthDay(MonthDay.of(Month.JANUARY, 11))  | false    || "団体割引 10% 適用期間外"
    }
}
