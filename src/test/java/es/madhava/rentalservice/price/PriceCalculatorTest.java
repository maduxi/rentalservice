package es.madhava.rentalservice.price;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriceCalculatorTest {

  @Test
  public void getPrice() {
    assertEquals("New release, one day", Double.valueOf(40), PriceCalculator.getPrice("NEW", 1));
    assertEquals("New release, one day", Double.valueOf(90), PriceCalculator.getPrice("REGULAR", 5));
    assertEquals("New release, one day", Double.valueOf(90), PriceCalculator.getPrice("REGULAR", 5));
    assertEquals("New release, one day", Double.valueOf(30), PriceCalculator.getPrice("REGULAR", 2));
    assertEquals("New release, one day", Double.valueOf(90), PriceCalculator.getPrice("OLD", 7));
  }

}
