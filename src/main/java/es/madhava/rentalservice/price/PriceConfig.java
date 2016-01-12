package es.madhava.rentalservice.price;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PriceConfig {
  Properties prop = new Properties();
  InputStream input = null;

  private static PriceConfig singleton = new PriceConfig();
  public static double PREMIUM_PRICE;
  public static double BASIC_PRICE;
  public final static String NEW = "NEW";
  public final static String REGULAR = "REGULAR";
  public final static String OLD = "OLD";

  /*
   * A private Constructor prevents any other class from instantiating.
   */
  private PriceConfig() {
    readPrices();
  }

  /* Static 'instance' method */
  public static PriceConfig getInstance() {
    return singleton;
  }

  private void readPrices() {
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      input = new FileInputStream(classLoader.getResource("price.properties").getFile());
      // load a properties file
      prop.load(input);
      // get the property value and print it out
      PREMIUM_PRICE = Double.parseDouble(prop.getProperty("premium"));
      BASIC_PRICE = Double.parseDouble(prop.getProperty("basic"));
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
