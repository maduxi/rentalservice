package es.madhava.rentalservice.price;

import static es.madhava.rentalservice.price.PriceConfig.BASIC_PRICE;
import static es.madhava.rentalservice.price.PriceConfig.NEW;
import static es.madhava.rentalservice.price.PriceConfig.OLD;
import static es.madhava.rentalservice.price.PriceConfig.PREMIUM_PRICE;
import static es.madhava.rentalservice.price.PriceConfig.REGULAR;

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
    cost = (Math.max(1, days - includedDays)) * price;
    return cost;
  }

  public static Double getSurchargeToday(String type, String rentDay, Long rentedDays) {
    LocalDate returnDate = LocalDate.now();
    LocalDate rentDate = LocalDate.parse(rentDay);
    Double surcharge = getSurcharge(type, rentedDays, rentDate, returnDate);
    return surcharge;
  }

  public static Double getSurcharge(String type, Long rentedDays, LocalDate rentDate, LocalDate returnDate) {
    Double surcharge = 0d;
    long totalDays = ChronoUnit.DAYS.between(rentDate, returnDate) + 1;
    long additional = totalDays - rentedDays;
    if (additional > 0) {
      if (type != null) {
        surcharge = PriceCalculator.getPrice(additional, getPriceForType(type), 0);
      }
    }
    return surcharge;
  }

  private static Double getPriceForType(String type) {
    return NEW.equalsIgnoreCase(type) ? PREMIUM_PRICE : BASIC_PRICE;
  }

  private static Integer getIncludedDays(String type) {
    Integer includedDays = 0;
    switch (type) {
    case NEW:
      includedDays = 0;
      break;
    case REGULAR:
      includedDays = 2;
      break;
    case OLD:
      includedDays = 4;
      break;
    }
    return includedDays;
  }

}
