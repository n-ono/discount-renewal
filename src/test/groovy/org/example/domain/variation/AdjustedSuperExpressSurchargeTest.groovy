package org.example.domain.variation

import org.example.domain.core.Amount
import org.example.domain.discount.amount.CalculatingSuperExpressSurcharge
import spock.lang.Specification

class AdjustedSuperExpressSurchargeTest extends Specification {

    def startDiscount() {
        setup:
        def adjustedSuperExpressSurcharge = new AdjustedSuperExpressSurcharge(Amount.from(1000))
        def expected = new CalculatingSuperExpressSurcharge(Amount.from(1000))

        expect:
        adjustedSuperExpressSurcharge.startDiscount() == expected
    }
}
