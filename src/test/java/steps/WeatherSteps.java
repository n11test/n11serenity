package steps;


import com.jayway.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;


public class WeatherSteps {
    Response r = null;
    String apiResponse;

    Weather weather= new Weather();



    @Step("^I get Request \"([^\"]*)\" for (\\d+) days weather$")
    public void iGetRequestForDaysWeather(String cityName, int days)  {
        r = given()
                .request().header("Content-Type", "application/json")
                .when()
                .get("http://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&APPID=ea574594b9d36ab688642d5fbeab847e");
    apiResponse = r.asString();
    System.out.println(apiResponse);
    }


    @Step("^I should see \"([^\"]*)\"$")
    public void iShouldSee(String value) {
        //Assert.assertThat(weather.JsonRead(apiResponse,"$.."+value), is(notNullValue()));
        Assert.assertThat(apiResponse, CoreMatchers.containsString(value));
    }
}
