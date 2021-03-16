package pl.allegro.restapi.tests.testbases;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;
import pl.allegro.restapi.main.properties.EndpointConfig;
import pl.allegro.restapi.main.properties.EnvironmentConfig;
import pl.allegro.restapi.main.request.configuration.RequestConfigurationBuilder;


public class TestBase {

    public EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
    public EndpointConfig endpointConfig = ConfigFactory.create(EndpointConfig.class);

    @BeforeSuite
    public void setupConfiguration() {
        RestAssured.baseURI = environmentConfig.baseUri();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = RequestConfigurationBuilder.getDefaultRequestSpecification();
    }

}
