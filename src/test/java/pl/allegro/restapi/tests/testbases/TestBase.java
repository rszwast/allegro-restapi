package pl.allegro.restapi.tests.testbases;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import pl.allegro.restapi.main.authentication.AppAuthentication;
import pl.allegro.restapi.main.logging.filters.LoggingFilters;
import pl.allegro.restapi.main.properties.EnvironmentConfig;

public class TestBase {

        public EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        @BeforeClass
        public void setupConfiguration(){
                RestAssured.baseURI = environmentConfig.baseUri();
                LoggingFilters.getLoggingFilters();
                RestAssured.requestSpecification = new RequestSpecBuilder().setAccept("application/vnd.allegro.public.v1+json").build();
                RestAssured.requestSpecification = new RequestSpecBuilder().addHeader("Authorization", "Bearer " + AppAuthentication.getAccessToken()).build();

        }



}
