package org.example.domain.discount.group;

/**
 * 団体の仕様
 */
public class GroupSpecification {

  /**
   * 普通団体の割引が適用される最小人数
   */
  public static final int NORMAL_GROUP_MINIMUM_NUMBERS = 31;

  /**
   * 普通団体の割引が適用される最大人数
   */
  public static final int NORMAL_GROUP_MAXIMUM_NUMBERS = 50;

  /**
   * 51 人以上の団体が割引を適用される単位
   */
  public static final int UNIT_NUMBERS = 50;
}
