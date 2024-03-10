package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})
public interface WebDriverConfig extends Config {
    @Key("baseUri")
    @Config.DefaultValue("https://reqres.in")
    String getBaseUri();

    @Key("basePath")
    @DefaultValue("/api")
    String getBasePath();

}