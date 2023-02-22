package org.example.domain.discount.group

import spock.lang.Specification

class SmallGroupTest extends Specification {

    def charged() {
        expect:
        new SmallGroup(2, 1).charged() == new ChargedGroup(2, 1)
    }
}
