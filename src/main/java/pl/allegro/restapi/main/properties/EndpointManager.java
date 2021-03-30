package pl.allegro.restapi.main.properties;

import org.aeonbits.owner.ConfigFactory;

public class EndpointManager {

    private static EndpointConfig endpointConfig;

    private EndpointManager(){}

    public static EndpointConfig getEndpointConfig(){
        if (endpointConfig == null){
            endpointConfig = ConfigFactory.create(EndpointConfig.class);
        }
        return endpointConfig;
    }
}
