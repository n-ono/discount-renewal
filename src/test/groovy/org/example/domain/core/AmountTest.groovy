package org.example.domain.core

import org.example.domain.discount.factory.Percentage
import spock.lang.Specification
import spock.lang.Unroll

class AmountTest extends Specification {

    def plus() {
        setup:
        def amount1 = Amount.from(1000)
        def amount2 = Amount.from(2000)

        expect:
        amount1.plus(amount2) == Amount.from(3000)
    }

    def half() {
        expect:
        Amount.from(3000).half() == Amount.from(1500)
    }

    def percentageOf() {
        setup:
        def amount = Amount.from(10000)
        def percentage = Percentage.ten()

        expect:
        amount.percentageOf(percentage) == Amount.from(1000)
    }

    @Unroll
    def "adjust - #description"() {
        setup:
        def amount = Amount.from(src)

        expect:
        amount == Amount.from(expected)

        where:
        src  | expected || description
        1000 | 1000     || "端数なし"
        1001 | 1000     || "端数あり ( 10 円未満は切り捨てる )"
        1010 | 1010     || "端数あり ( 10 円以上は切り捨てない )"
    }
}
