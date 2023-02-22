package org.example.domain.discount.group

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LargeGroupTest extends Specification {

    def "charged - #description"() {
        expect:
        new LargeGroup(adults, children).charged() == expected

        where:
        adults | children | expected                 || description
        45     | 56       | new ChargedGroup(43, 56) || "大人が優先的に無料になる"
        1      | 100      | new ChargedGroup(0, 99)  || "大人と子供が 1 人ずつ無料になる"
        0      | 200      | new ChargedGroup(0, 196) || "大人がいない場合は子供が無料になる"
    }
}
