package questions.responseNonSuccessful;

import net.serenitybdd.screenplay.Question;

public class GivenResponse {
    public static Question<String> message(){return new ResponseMessage();}
    public static Question<String> errorMessage(){return new ResponseErrorMessage();}
}
