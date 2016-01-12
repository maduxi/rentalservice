package es.madhava.rentalservice.price;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PriceConfig {

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
    InputStream resourceInputStream = null;
    try {
      Properties prop = new Properties();
      Resource resource = new ClassPathResource("price.properties");
      resourceInputStream = resource.getInputStream();
      // load a properties file
      prop.load(resourceInputStream);
      // get the property value and print it out
      PREMIUM_PRICE = Double.parseDouble(prop.getProperty("premium"));
      BASIC_PRICE = Double.parseDouble(prop.getProperty("basic"));
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      if (resourceInputStream != null) {
        try {
          resourceInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
