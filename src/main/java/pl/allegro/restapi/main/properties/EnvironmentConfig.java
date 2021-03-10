package pl.allegro.restapi.main.properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:EnvironmentConfig.properties")
public interface EnvironmentConfig extends Config {

    @Key("BASE_URI")
    String baseUri();

    @Key("SALE_PATH")
    String salePath();

    @Key("TOKEN_PATH")
    String tokenPath();

}
