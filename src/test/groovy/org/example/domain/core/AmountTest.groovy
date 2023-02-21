package org.example.domain.core

import spock.lang.Specification
import spock.lang.Unroll

class AmountTest extends Specification {

    def half() {
        expect:
        Amount.from(3000).half() == Amount.from(1500)
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
