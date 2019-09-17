package models.parameters;

import java.util.HashMap;

public class ParameterBuilder {
    private HashMap<String, String> parameters;


    public ParameterBuilder() {
        this.parameters = new HashMap<>();
    }

    public static ParameterBuilder parameters() {
        return new ParameterBuilder();
    }

    public ParameterBuilder withQ(String q){
        this.parameters.put(ParametersNames.q.toString(), q);
        return this;
    }

    public ParameterBuilder withSort(String sort){
        this.parameters.put(ParametersNames.sort.toString(), sort);
        return this;
    }

    public ParameterBuilder withOrder(String order){
        this.parameters.put(ParametersNames.order.toString(), order);
        return this;
    }

    public ParameterBuilder onPage(String page){
        this.parameters.put(ParametersNames.page.toString(), page);
        return this;
    }

    public ParameterBuilder withResultsPerPage(String perPage){
        this.parameters.put(ParametersNames.per_page.toString(), perPage);
        return this;
    }

    public Parameters build(){
        return new Parameters(this.parameters);
    }

}
