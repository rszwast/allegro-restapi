package pl.allegro.restapi.tests.parameters;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.main.pojo.categories.Categories;
import pl.allegro.restapi.main.pojo.categories.Category;
import pl.allegro.restapi.main.pojo.parameters.Parameter;
import pl.allegro.restapi.main.pojo.parameters.Parameters;
import pl.allegro.restapi.tests.testbases.TestBase;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;


public class GetParametersByCategoryIdTest extends TestBase {

    @Test
    public void givenCategoryIdWhenGetParametersThenReturnListOfParameters() {
        Categories categories = given()
                .when().get(endpointConfig.getAllCategoriesPath())
                .then().statusCode(HttpStatus.SC_OK).extract().as(Categories.class);

        List<Category> listOfCategories = categories.getCategories();

        int sizeOfCategories = listOfCategories.size();

        Random random = new Random();
        Category category = listOfCategories.get(random.nextInt(sizeOfCategories));

        String categoryId = category.getId();

        Parameters parameters = given()
                .when().get(endpointConfig.getParametersByCategoryPath(), categoryId)
                .then().statusCode(HttpStatus.SC_OK).extract().as(Parameters.class);

        List<Parameter> listOfParameters = parameters.getParameters();

        int sizeOfParameters = listOfParameters.size();

        for (int i = 0; i < sizeOfParameters; i++) {
            String parameterType = listOfParameters.get(i).getType();
            System.out.println(parameterType);
            Assertions.assertThat(parameterType).isNotEmpty();
        }

    }

}
