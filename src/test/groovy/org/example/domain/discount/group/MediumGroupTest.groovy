package org.example.domain.discount.group

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MediumGroupTest extends Specification {

    def "charged - #description"() {
        expect:
        new MediumGroup(adults, children).charged() == expected

        where:
        adults | children | expected                || description
        10     | 21       | new ChargedGroup(9, 21) || "大人が優先的に無料になる"
        0      | 40       | new ChargedGroup(0, 39) || "大人がいない場合は子供が無料になる"
    }
}
