package org.example.domain.discount.factory;

import org.example.domain.core.DepartureMonthDay;
import org.example.domain.discount.group.Group;

/**
 * 団体割引率ファクトリ
 */
public class GroupDiscountPercentageFactory {

  /**
   * 団体割引が適用される最低人数
   */
  private static final int MINIMUM_APPLICABLE_NUMBERS = 8;

  /**
   * 団体人数と出発日から割引率を算出する
   *
   * @param group             団体
   * @param departureMonthDay 出発日
   * @return 適用される団体割引率
   */
  public static Percentage create(Group group, DepartureMonthDay departureMonthDay) {
    if (MINIMUM_APPLICABLE_NUMBERS <= group.total()) {
      if (GroupDiscountTenApplicationTerm.include(departureMonthDay)) {
        return Percentage.ten();
      } else {
        return Percentage.fifteen();
      }
    } else {
      return Percentage.zero();
    }
  }
}
