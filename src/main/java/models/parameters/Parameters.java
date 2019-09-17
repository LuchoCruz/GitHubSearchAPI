package models.parameters;

import java.util.HashMap;

public class Parameters {
    private HashMap<String, String> parameters;

    public Parameters(HashMap<String, String> parameters){
        this.parameters = parameters;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

}
