package org.example.domain.discount.group;

/**
 * 普通団体
 * <p>
 * 普通団体とは 31-50 人の団体のこと
 * <p>
 * 日本語的にクラス名は NormalGroup が適切な気がするが、Small, Large に合わせて Medium とした
 */
public class MediumGroup extends Group {

  /**
   * コンストラクタ
   *
   * @param adults   大人の人数
   * @param children 子供の人数
   */
  public MediumGroup(int adults, int children) {
    super(adults, children);
  }

  /**
   * 課金対象の団体を返す
   * <p>
   * 1 人分の料金が無料になる
   * <p>
   * 大人と子供が混在する団体の場合、大人を優先的に無料にする
   *
   * @return 課金対象の団体
   */
  public ChargedGroup charged() {
    int discountedAdults = Math.min(adults, 1);
    int discountedChildren = 1 - discountedAdults;
    return new ChargedGroup(adults - discountedAdults, children - discountedChildren);
  }
}
