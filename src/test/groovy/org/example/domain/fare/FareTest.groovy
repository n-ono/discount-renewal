package org.example.domain.fare

import org.example.domain.core.Amount
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
}
