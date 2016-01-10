package es.madhava.rentalservice.price;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriceCalculatorTest {

  @Test
  public void getPrice() {
    assertEquals("New release, one day", Double.valueOf(40), PriceCalculator.getNewRentPrice("NEW", 1l));
    assertEquals("New release, one day", Double.valueOf(90), PriceCalculator.getNewRentPrice("REGULAR", 5l));
    assertEquals("New release, one day", Double.valueOf(90), PriceCalculator.getNewRentPrice("REGULAR", 5l));
    assertEquals("New release, one day", Double.valueOf(30), PriceCalculator.getNewRentPrice("REGULAR", 2l));
    assertEquals("New release, one day", Double.valueOf(90), PriceCalculator.getNewRentPrice("OLD", 7l));
  }

}
