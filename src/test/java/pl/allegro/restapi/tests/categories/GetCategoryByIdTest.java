package pl.allegro.restapi.tests.categories;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.main.pojo.categories.Categories;
import pl.allegro.restapi.main.pojo.categories.Category;
import pl.allegro.restapi.main.pojo.categories.Options;
import pl.allegro.restapi.tests.testbases.TestBase;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class GetCategoryByIdTest extends TestBase {

    @Test
    public void givenRandomCategoryFromCategoriesWhenGetCategoryThenReturnCategory(){
        Categories expectedCategories = given()
                .when().get(environmentConfig.salePath() + endpointConfig.getAllCategoriesPath())
                .then().statusCode(HttpStatus.SC_OK).extract().as(Categories.class);

        List<Category> listOfExpectedCategories = expectedCategories.getCategories();

        int numerOfExpectedCategories = listOfExpectedCategories.size();

        Random random = new Random();

        Category expectedCategory = listOfExpectedCategories.get(random.nextInt(numerOfExpectedCategories));

        Assertions.assertThat(expectedCategory.getLeaf()).isFalse();

        String expectedCategoryId = expectedCategory.getId();
        Boolean expectedLeaf = expectedCategory.getLeaf();
        String expectedName = expectedCategory.getName();

        Options expectedOptions = expectedCategory.getOptions();
        Boolean expectedAdvertisementPriceOptional = expectedOptions.getAdvertisementPriceOptional();
        Boolean expectedVariantsByColorPatternAllowed = expectedOptions.getVariantsByColorPatternAllowed();
        Boolean expectedOffersWithProductPublicationEnabled = expectedOptions.getOffersWithProductPublicationEnabled();
        Boolean expectedProductCreationEnabled = expectedOptions.getProductCreationEnabled();
        Boolean expectedCustomParametersEnabled = expectedOptions.getCustomParametersEnabled();


        Category category = given()
                .when().get(environmentConfig.salePath() + endpointConfig.getCategoryByIdPath(), expectedCategoryId)
                .then().statusCode(HttpStatus.SC_OK).extract().as(Category.class);

        Assertions.assertThat(category.getId()).isEqualTo(expectedCategoryId);
        Assertions.assertThat(category.getLeaf()).isEqualTo(expectedLeaf);
        Assertions.assertThat(category.getName()).isEqualTo(expectedName);
        Assertions.assertThat(category.getOptions().getAdvertisementPriceOptional()).isEqualTo(expectedAdvertisementPriceOptional);
        Assertions.assertThat(category.getOptions().getVariantsByColorPatternAllowed()).isEqualTo(expectedVariantsByColorPatternAllowed);
        Assertions.assertThat(category.getOptions().getOffersWithProductPublicationEnabled()).isEqualTo(expectedOffersWithProductPublicationEnabled);
        Assertions.assertThat(category.getOptions().getProductCreationEnabled()).isEqualTo(expectedProductCreationEnabled);
        Assertions.assertThat(category.getOptions().getCustomParametersEnabled()).isEqualTo(expectedCustomParametersEnabled);

// Aby zmniejszyć ilość kodu, można również porównać ze sobą dwa obiekty typu Category dodając metodę usingRecursiveComparison() w asercji
        //Assertions.assertThat(category).usingRecursiveComparison().isEqualTo(expectedCategory);

    }

}
