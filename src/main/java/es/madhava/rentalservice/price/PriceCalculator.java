package es.madhava.rentalservice.price;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PriceCalculator {

  public static Double getNewRentPrice(String type, Long days) {
    Double cost;
    Integer includedDays;
    Double price = getPriceForType(type);
    includedDays = getIncludedDays(type);
    cost = getPrice(days, price, includedDays);
    return cost;
  }

  private static Double getPrice(Long days, Double price, Integer includedDays) {
    Double cost;
    cost = (1 + Math.max(0, days - includedDays)) * price;
    return cost;
  }

  public static Double getSurcharge(String type, String rentDay, Long rentedDays) {
    Double surcharge = 0d;
    long totalDays = ChronoUnit.DAYS.between(LocalDate.parse(rentDay), LocalDate.now());
    long additional = totalDays - rentedDays;
    if (additional > 0) {
      if (type != null) {
        surcharge = PriceCalculator.getPrice(totalDays, getPriceForType(type), 0);
      }
    }
    return surcharge;
  }

  private static Double getPriceForType(String type) {
    Double price;
    if (type == "NEW") {
      price = PriceConfig.PREMIUM_PRICE;
    } else {
      price = PriceConfig.BASIC_PRICE;
    }
    return price;
  }

  private static Integer getIncludedDays(String type) {
    Integer includedDays;
    if (type == "NEW") {
      includedDays = 1;
    } else {
      if (type == "REGULAR") {
        includedDays = 3;
      } else {
        includedDays = 5;
      }
    }
    return includedDays;
  }

}
