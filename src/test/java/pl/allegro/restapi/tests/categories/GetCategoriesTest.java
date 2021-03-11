package pl.allegro.restapi.tests.categories;

import org.testng.annotations.Test;
import pl.allegro.restapi.tests.testbases.TestBase;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetCategoriesTest extends TestBase {

    @Test
    public void givenCategoriesWhenGetCategoriesThenReturnListOfAllCategories(){
        Response response = given().when().get(environmentConfig.salePath() + "/categories")
                .then().extract().response();
    }

}
