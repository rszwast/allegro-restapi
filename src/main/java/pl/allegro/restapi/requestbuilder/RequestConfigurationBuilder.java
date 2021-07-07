package pl.allegro.restapi.requestbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;
import pl.allegro.restapi.authentication.Authentication;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class RequestConfigurationBuilder {

    private RequestConfigurationBuilder(){}

    public static RequestSpecification getDefaultRequestSpecification(){
        RequestConfigurationBuilder requestConfigurationBuilder = new RequestConfigurationBuilder();
        return requestConfigurationBuilder
                .getRequestSpecBuilder().build();
    }

    public static RequestSpecBuilder getRequestSpecBuilder() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        return requestSpecBuilder
                .setConfig(RestAssuredConfig.config().objectMapperConfig(objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON)))
                .setAccept("application/vnd.allegro.public.v1+json")
                .addHeader("Authorization", "Bearer " + Authentication.getAccessToken());
    }
}

