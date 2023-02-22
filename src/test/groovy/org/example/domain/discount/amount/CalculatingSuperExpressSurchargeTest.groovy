package org.example.domain.discount.amount

import org.example.domain.core.Amount
import org.example.domain.discount.factory.Percentage
import org.example.domain.super_express_surcharge.SuperExpressSurcharge
import spock.lang.Specification

class CalculatingSuperExpressSurchargeTest extends Specification {

    def discounted() {
        setup:
        def calculatingSuperExpressSurcharge = new CalculatingSuperExpressSurcharge(Amount.from(1000))
        def percentage = Percentage.fifteen()

        expect:
        calculatingSuperExpressSurcharge.discounted(percentage) == new CalculatingSuperExpressSurcharge(Amount.from(850))
    }

    def endDiscount() {
        setup:
        def calculatingSuperExpressSurcharge = new CalculatingSuperExpressSurcharge(Amount.from(1000))

        expect:
        calculatingSuperExpressSurcharge.endDiscount() == new SuperExpressSurcharge(Amount.from(1000))
    }
}
