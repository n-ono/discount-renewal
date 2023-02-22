package org.example.domain.discount.group;

/**
 * 51 人以上の団体
 */
public class LargeGroup extends Group {

  /**
   * コンストラクタ
   *
   * @param adults   大人の人数
   * @param children 子供の人数
   */
  public LargeGroup(int adults, int children) {
    super(adults, children);
  }

  /**
   * 課金対象の団体を返す
   * <p>
   * 50 人増えるごとに 1 人分の料金が無料になる
   * <p>
   * 大人と子供が混在する団体の場合、大人を優先的に無料にする
   *
   * @return 課金対象の団体
   */
  public ChargedGroup charged() {
    int maxDiscountedNumbers = total() / GroupSpecification.UNIT_NUMBERS;
    int discountedAdults = Math.min(adults, maxDiscountedNumbers);
    int discountedChildren = maxDiscountedNumbers - discountedAdults;
    return new ChargedGroup(adults - discountedAdults, children - discountedChildren);
  }
}
