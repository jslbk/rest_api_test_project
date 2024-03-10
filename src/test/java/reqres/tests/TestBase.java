package reqres.tests;

import driver.WebDriverProvider;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.setConfig();
    }
}
