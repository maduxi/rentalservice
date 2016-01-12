package es.madhava.rentalservice.price;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class PriceCalculatorTest {

  @Test
  public void getPrice() {
    assertEquals("New release, one day", Double.valueOf(40), PriceCalculator.getNewRentPrice("NEW", 1l));
    assertEquals("Regular release, five days", Double.valueOf(90), PriceCalculator.getNewRentPrice("REGULAR", 5l));
    assertEquals("Regular release, 2 days", Double.valueOf(30), PriceCalculator.getNewRentPrice("REGULAR", 2l));
    assertEquals("Old release, 7 days", Double.valueOf(90), PriceCalculator.getNewRentPrice("OLD", 7l));
  }

  @Test
  public void getSurcharge() {
    assertEquals("Two days more, new release", Double.valueOf(80),
        PriceCalculator.getSurcharge("NEW", 3l, LocalDate.parse("2016-01-01"), LocalDate.parse("2016-01-05")));
    assertEquals("Regular release, one day", Double.valueOf(30),
        PriceCalculator.getSurcharge("REGULAR", 3l, LocalDate.parse("2016-01-01"), LocalDate.parse("2016-01-04")));
  }
}
