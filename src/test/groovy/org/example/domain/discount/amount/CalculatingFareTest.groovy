package org.example.domain.discount.amount

import org.example.domain.core.Amount
import org.example.domain.discount.factory.Percentage
import org.example.domain.fare.Fare
import spock.lang.Specification

class CalculatingFareTest extends Specification {

    def discounted() {
        setup:
        def calculatingFare = new CalculatingFare(Amount.from(1000))
        def percentage = Percentage.fifteen()

        expect:
        calculatingFare.discounted(percentage) == new CalculatingFare(Amount.from(850))
    }

    def endDiscount() {
        setup:
        def calculatingFare = new CalculatingFare(Amount.from(1000))

        expect:
        calculatingFare.endDiscount() == new Fare(Amount.from(1000))
    }
}
