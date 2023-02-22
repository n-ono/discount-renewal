package org.example.domain.price

import org.example.domain.core.Amount
import org.example.domain.fare.Fare
import org.example.domain.super_express_surcharge.SuperExpressSurcharge
import spock.lang.Specification

class PriceTest extends Specification {

    def forChild() {
        setup:
        def fare = new Fare(Amount.from(8910))
        def superExpressSurcharge = new SuperExpressSurcharge(Amount.from(5490))
        def price = new Price(fare, superExpressSurcharge)
        def expected = Amount.from(7190)

        expect:
        price.forChild() == expected
    }

    def forAdult() {
        setup:
        def fare = new Fare(Amount.from(8910))
        def superExpressSurcharge = new SuperExpressSurcharge(Amount.from(5490))
        def price = new Price(fare, superExpressSurcharge)
        def expected = Amount.from(14400)

        expect:
        price.forAdult() == expected
    }
}
