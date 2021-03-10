package pl.allegro.restapi.main.authentication;

import org.aeonbits.owner.ConfigFactory;
import pl.allegro.restapi.main.properties.EnvironmentConfig;

import static io.restassured.RestAssured.given;

public class AppAuthentication {

    public static String getAccessToken() {
        EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        String accessToken = given()
                .formParam("grant_type", "client_credentials")
                .auth().preemptive().basic(ClientCredentials.CLIENT_ID, ClientCredentials.CLIENT_SECRET)
                .contentType("application/x-www-form-urlencoded")
                .when()
                .post(environmentConfig.baseUri(), environmentConfig.tokenPath())
                .then().extract().jsonPath().getString("access_token");
        return accessToken;
    }

}
