package questions.responseSuccessful;

import models.FieldsValidation;
import models.ResponseStructure;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseFields implements Question<Boolean> {
    private ResponseStructure response;
    public ResponseFields(ResponseStructure response){
        this.response = response;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        FieldsValidation validation = new FieldsValidation(response);
        return validation.validateFields();
    }

    public static ResponseFields areCorrect(ResponseStructure response){
        return new ResponseFields(response);
    }
}
