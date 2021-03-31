package pl.allegro.restapi.tests.testbases;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;
import pl.allegro.restapi.main.request.configuration.RequestConfigurationBuilder;

import static pl.allegro.restapi.main.properties.EnvironmentManager.getEnvironmentConfig;


public class TestBase {

    @BeforeSuite
    public void setupConfiguration() {
        RestAssured.baseURI = getEnvironmentConfig().baseUri();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = RequestConfigurationBuilder.getDefaultRequestSpecification();
    }

}
