package es.madhava.rentalservice.price;

public class PriceCalculator {

  public static Double getPrice(String type, int days) {
    Double price;
    if (type == "NEW") {
      price = PriceConfig.PREMIUM_PRICE * days;
    } else if (type == "REGULAR") {
      price = PriceConfig.BASIC_PRICE + (PriceConfig.BASIC_PRICE * Math.max(0, days - 3));
    } else {
      price = PriceConfig.BASIC_PRICE + (PriceConfig.BASIC_PRICE * Math.max(0, days - 5));
    }
    return price;
  }

}
