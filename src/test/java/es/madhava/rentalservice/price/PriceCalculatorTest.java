package es.madhava.rentalservice.price;

import static org.junit.Assert.assertEquals;

import static es.madhava.rentalservice.price.PriceConfig.BASIC_PRICE;
import static es.madhava.rentalservice.price.PriceConfig.NEW;
import static es.madhava.rentalservice.price.PriceConfig.OLD;
import static es.madhava.rentalservice.price.PriceConfig.PREMIUM_PRICE;
import static es.madhava.rentalservice.price.PriceConfig.REGULAR;

import java.time.LocalDate;

import org.junit.Test;

public class PriceCalculatorTest {

  @Test
  public void getPrice() {
    assertEquals("New release, one day", Double.valueOf(PREMIUM_PRICE), PriceCalculator.getNewRentPrice(NEW, 1l));
    assertEquals("Regular release, five days", Double.valueOf(BASIC_PRICE * 3),
        PriceCalculator.getNewRentPrice(REGULAR, 5l));
    assertEquals("Regular release, 2 days", Double.valueOf(BASIC_PRICE), PriceCalculator.getNewRentPrice(REGULAR, 2l));
    assertEquals("Old release, 7 days", Double.valueOf(BASIC_PRICE * 3), PriceCalculator.getNewRentPrice(OLD, 7l));
  }

  @Test
  public void getSurcharge() {
    assertEquals("Two days more, new release", Double.valueOf(PREMIUM_PRICE * 2),
        PriceCalculator.getSurcharge(NEW, 3l, LocalDate.parse("2016-01-01"), LocalDate.parse("2016-01-05")));
    assertEquals("One day more, Regular release", Double.valueOf(BASIC_PRICE),
        PriceCalculator.getSurcharge(REGULAR, 3l, LocalDate.parse("2016-01-01"), LocalDate.parse("2016-01-04")));
    assertEquals("No additional days, regular release", Double.valueOf(0),
        PriceCalculator.getSurcharge(REGULAR, 5l, LocalDate.parse("2016-01-01"), LocalDate.parse("2016-01-04")));
  }
}
