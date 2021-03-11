package pl.allegro.restapi.main.authentication;

import org.aeonbits.owner.ConfigFactory;
import pl.allegro.restapi.main.properties.EnvironmentConfig;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.main.authentication.ClientCredentials.CLIENT_ID;
import static pl.allegro.restapi.main.authentication.ClientCredentials.CLIENT_SECRET;

public class Authentication {

    public static String getAccessToken() {
        EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        String accessToken = given()
                .formParam("grant_type", "client_credentials")
                .auth().preemptive().basic(CLIENT_ID, CLIENT_SECRET)
                .contentType("application/x-www-form-urlencoded")
                .when()
                .post(environmentConfig.tokenUri())
                .then().extract().jsonPath().getString("access_token");
        return accessToken;
    }

}
