package org.example.domain.discount.factory

import org.example.domain.core.DepartureMonthDay
import org.example.domain.discount.group.GroupFactory
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Month
import java.time.MonthDay

@Unroll
class GroupDiscountPercentageFactoryTest extends Specification {

    def "create - #description"() {
        expect:
        GroupDiscountPercentageFactory.create(group, departureMonthDay) == expected

        where:
        group                     | departureMonthDay                                      | expected             || description
        GroupFactory.create(8, 0) | new DepartureMonthDay(MonthDay.of(Month.DECEMBER, 21)) | Percentage.ten()     || "総勢 8 名で団体割引 10% 適用期間に旅行する"
        GroupFactory.create(8, 0) | new DepartureMonthDay(MonthDay.of(Month.OCTOBER, 30))  | Percentage.fifteen() || "総勢 8 名で団体割引 10% 適用期間外に旅行する"
        GroupFactory.create(7, 0) | new DepartureMonthDay(MonthDay.of(Month.OCTOBER, 30))  | Percentage.zero()    || "総勢 7 名で団体割引 10% 適用期間外に旅行する"
    }
}
