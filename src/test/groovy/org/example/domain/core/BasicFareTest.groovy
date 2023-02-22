package org.example.domain.core

import org.example.domain.discount.amount.CalculatingFare
import spock.lang.Specification

class BasicFareTest extends Specification {

    def startDiscount() {
        setup:
        def basicFare = new BasicFare(Amount.from(1000))

        expect:
        basicFare.startDiscount() == new CalculatingFare(Amount.from(1000))
    }
}
