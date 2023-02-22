package org.example.domain.discount.group

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class GroupFactoryTest extends Specification {

    def "create - #description"() {
        expect:
        GroupFactory.create(adults, children).getClass() == expected

        where:
        adults | children | expected                           || description
        1      | 0        | new SmallGroup(1, 0).getClass()    || "総勢 31 人未満の団体"
        10     | 21       | new MediumGroup(10, 21).getClass() || "総勢 31 人以上 50 人未満の団体"
        20     | 31       | new LargeGroup(10, 21).getClass()  || "総勢 51 人以上の団体"
    }
}
