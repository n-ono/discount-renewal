package org.example.domain.super_express_surcharge

import org.example.domain.core.Amount
import spock.lang.Specification

class SuperExpressSurchargeTest extends Specification {

    def forChild() {
        setup:
        def superExpressSurcharge = new SuperExpressSurcharge(Amount.from(1000))
        def expected = Amount.from(500)

        expect:
        superExpressSurcharge.forChild() == expected
    }

    def forAdult() {
        setup:
        def superExpressSurcharge = new SuperExpressSurcharge(Amount.from(1000))
        def expected = Amount.from(1000)

        expect:
        superExpressSurcharge.forAdult() == expected
    }
}
