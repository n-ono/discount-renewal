package org.example.domain.discount.group;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 団体
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public abstract class Group {

  protected final int adults;

  protected final int children;

  /**
   * 課金対象の団体を返す
   *
   * @return 課金対象の団体
   */
  public abstract ChargedGroup charged();

  /**
   * 団体の総数を返す
   *
   * @return 団体の総数
   */
  public int total() {
    return adults + children;
  }
}
