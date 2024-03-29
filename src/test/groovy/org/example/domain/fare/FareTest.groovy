package org.example.domain.fare

import org.example.domain.core.Amount
import org.example.domain.price.Price
import org.example.domain.super_express_surcharge.SuperExpressSurcharge
import spock.lang.Specification

class FareTest extends Specification {

    def forChild() {
        expect:
        new Fare(Amount.from(1000)).forChild() == Amount.from(500)
    }

    def forAdult() {
        expect:
        new Fare(Amount.from(1000)).forAdult() == Amount.from(1000)
    }

    def plus() {
        setup:
        def fare = new Fare(Amount.from(1000))
        def superExpressSurcharge = new SuperExpressSurcharge(Amount.from(2000))
        def expected = new Price(new Fare(Amount.from(1000)), new SuperExpressSurcharge(Amount.from(2000)))

        expect:
        fare.plus(superExpressSurcharge) == expected
    }
}
