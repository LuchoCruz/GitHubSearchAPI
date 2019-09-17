package questions.responseNonSuccessful;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseErrorMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return (String) lastResponse().jsonPath().getList("errors.message").get(0);
    }

    public static ResponseErrorMessage is(){
        return new ResponseErrorMessage();
    }
}
