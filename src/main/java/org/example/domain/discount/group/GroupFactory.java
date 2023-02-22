package org.example.domain.discount.group;

/**
 * 団体ファクトリ
 */
public class GroupFactory {

  /**
   * 旅行する人数から対応する団体を返す
   *
   * @param adults   大人の人数
   * @param children 子供の人数
   * @return 団体
   */
  public static Group create(int adults, int children) {
    int total = adults + children;
    if (GroupSpecification.NORMAL_GROUP_MINIMUM_NUMBERS <= total
        && total <= GroupSpecification.NORMAL_GROUP_MAXIMUM_NUMBERS) {
      return new MediumGroup(adults, children);
    } else if (GroupSpecification.NORMAL_GROUP_MAXIMUM_NUMBERS < total) {
      return new LargeGroup(adults, children);
    } else {
      return new SmallGroup(adults, children);
    }
  }
}
