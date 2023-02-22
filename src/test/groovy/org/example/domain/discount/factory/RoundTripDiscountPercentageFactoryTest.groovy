package org.example.domain.discount.factory

import org.example.domain.core.BusinessKilometer
import spock.lang.Specification
import spock.lang.Unroll

import static org.example.domain.core.Goods.TripType.OneWay
import static org.example.domain.core.Goods.TripType.Round

@Unroll
class RoundTripDiscountPercentageFactoryTest extends Specification {

    def "create - #description"() {
        expect:
        RoundTripDiscountPercentageFactory.create(tripType, businessKilometer) == expected

        where:
        tripType | businessKilometer          | expected          || description
        OneWay   | new BusinessKilometer(553) | Percentage.zero() || "新大阪までの片道旅行"
        OneWay   | new BusinessKilometer(644) | Percentage.zero() || "姫路までの片道旅行"
        Round    | new BusinessKilometer(553) | Percentage.zero() || "新大阪までの往復旅行"
        Round    | new BusinessKilometer(644) | Percentage.ten()  || "姫路までの往復旅行"
    }
}
