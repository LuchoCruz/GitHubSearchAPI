package questions.responseSuccessful;

import models.ResponseStructure;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ListedItems implements Question<Integer> {
    private ResponseStructure response;
    public ListedItems(ResponseStructure response){
        this.response = response;
    }
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().jsonPath().getList("items").size();
    }

    public static ListedItems count(ResponseStructure response){
        return new ListedItems(response);
    }
}
