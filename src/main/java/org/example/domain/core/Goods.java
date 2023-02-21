package org.example.domain.core;

/**
 * 提供する商品
 */
public class Goods {

  /**
   * 旅行区分
   * <p>
   * 片道 ( OneWay ) と往復 ( Round ) の 2 種類
   */
  public enum TripType {
    OneWay, Round
  }

  /**
   * 座席区分
   * <p>
   * 自由席 ( NonReserved ) と指定席 ( Reserved ) の 2 種類
   */
  public enum SeatType {
    NonReserved, Reserved
  }
}
