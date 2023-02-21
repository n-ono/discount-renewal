package org.example.domain.core

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class BusinessKilometerTest extends Specification {

    def "isDiscountable - #description"() {
        setup:
        def businessKilometer = new BusinessKilometer(src)

        expect:
        businessKilometer.isDiscountable() == expected

        where:
        src | expected || description
        600 | false    || "601km 以下は割引対象外"
        601 | true     || "601km 以上は割引対象"
    }
}
