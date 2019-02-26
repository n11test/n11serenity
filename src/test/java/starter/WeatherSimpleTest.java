package starter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.WeatherSteps;

@RunWith(SerenityRunner.class)
public class WeatherSimpleTest {

    @Steps
    public WeatherSteps weather;

    @Test
    public void weatherCheck(){
        weather.iGetRequestForDaysWeather("London",5);
        weather.iShouldSee("humidity");
        weather.iShouldSee("temp");
    }
}
