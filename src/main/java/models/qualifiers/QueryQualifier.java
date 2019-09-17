package models.qualifiers;


import java.util.HashMap;
import java.util.Map;

public class QueryQualifier {
    private HashMap<String, String> qualifiers;

    public QueryQualifier(HashMap<String, String> qualifiers){
        this.qualifiers = qualifiers;
    }

    public String getList() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry: qualifiers.entrySet()) {
            sb.append(entry.getKey() + ":" + entry.getValue());
        }
        return sb.toString();
    }
}
