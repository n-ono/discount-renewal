package org.example.domain.discount.group;

/**
 * 少数団体
 */
public class SmallGroup extends Group {

  /**
   * コンストラクタ
   *
   * @param adults   大人の人数
   * @param children 子供の人数
   */
  public SmallGroup(int adults, int children) {
    super(adults, children);
  }

  /**
   * 課金対象の団体を返す
   * <p>
   * 少数団体は無料対象者がいないので全員が課金対象となる
   *
   * @return 課金対象の団体
   */
  public ChargedGroup charged() {
    return new ChargedGroup(adults, children);
  }
}
