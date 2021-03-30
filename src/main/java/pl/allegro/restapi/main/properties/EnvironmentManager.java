package pl.allegro.restapi.main.properties;

import org.aeonbits.owner.ConfigFactory;

public class EnvironmentManager {

    private static EnvironmentConfig environmentConfig;

    private EnvironmentManager(){}

    public static EnvironmentConfig getEnvironmentConfig(){
        if (environmentConfig == null){
            environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        }
        return environmentConfig;
    }

}
