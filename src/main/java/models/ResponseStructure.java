package models;

import java.util.HashMap;

public interface ResponseStructure {
    HashMap<String, String> getFields();
    HashMap<String, String> getNonNestedItems();
}
