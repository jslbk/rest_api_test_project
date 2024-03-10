package driver;

import config.WebDriverConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverProvider {
    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    public static void setConfig() {
        RestAssured.baseURI = config.getBaseUri();
        RestAssured.basePath = config.getBasePath();
    }

}