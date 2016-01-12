package es.madhava.rentalservice.points;

import static es.madhava.rentalservice.price.PriceConfig.NEW;

public class BonusPointsCalculator {

  public static Long getBonusPoints(String type) {
    return NEW.equalsIgnoreCase(type) ? 2l : 1l;
  }

}
