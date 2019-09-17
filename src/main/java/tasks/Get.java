package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Get implements Task {
    private String resourceURI;
    private HashMap<String, String> parameters;

    public Get(String resourceURI, HashMap<String, String> parameters) {
        this.resourceURI = resourceURI;
        this.parameters = parameters;
    }

    @Step("{0} executes a GET request")
    @Override
    public <T extends Actor> void performAs(T actor) {
        given().contentType("application/json")
                .queryParams(parameters)
                .get(resourceURI);
    }

    public static Get resource(String resourceURI, HashMap<String, String> parameters) {
        return instrumented(Get.class, resourceURI, parameters);
    }
}
