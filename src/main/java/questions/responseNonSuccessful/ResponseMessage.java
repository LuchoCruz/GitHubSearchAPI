package questions.responseNonSuccessful;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().jsonPath().get("message");
    }

    public static ResponseMessage is(){
        return new ResponseMessage();
    }
}
