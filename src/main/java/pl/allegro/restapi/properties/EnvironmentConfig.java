package pl.allegro.restapi.properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:EnvironmentConfig.properties")
public interface EnvironmentConfig extends Config {

    @Key("TOKEN_URI")
    String tokenUri();

    @Key("BASE_URI")
    String baseUri();

}
