package models;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class FieldsValidation {
    private ResponseStructure response;

    public FieldsValidation(ResponseStructure response) {
        this.response = response;
    }

    public boolean validateFields() {
        Set<Entry<String, String>> fields;
        if (responseListedItemsIsEmpty()) fields = response.getNonNestedItems().entrySet();
        else
            fields = response.getFields().entrySet();

        for (Map.Entry<String, String> entry : fields) {
            if (!fieldIsNull(entry.getKey()) && !fieldIsType(entry.getKey(), entry.getValue())) return false;
        }
        return true;
    }

    private boolean responseListedItemsIsEmpty() {
        return lastResponse().jsonPath().getList("items").size() == 0;
    }

    private boolean fieldIsType(String fieldName, String fieldType) {
        if (fieldIsInAList(fieldName)) {
            return lastResponse().jsonPath().getList(fieldName).get(0).getClass().getName().contains(fieldType);
        } else
            return lastResponse().jsonPath().get(fieldName).getClass().getName().contains(fieldType);
    }

    private boolean fieldIsNull(String fieldName) {
        if (fieldIsInAList(fieldName)) {
            return lastResponse().jsonPath().getList(fieldName).get(0) == null;
        } else
            return lastResponse().jsonPath().get(fieldName) == null;
    }

    private boolean fieldIsInAList(String fieldName) {
        return (lastResponse().jsonPath().get(fieldName).getClass().getName().contains("Array"));
    }
}
