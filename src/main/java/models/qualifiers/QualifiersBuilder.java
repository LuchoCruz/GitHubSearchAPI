package models.qualifiers;

import java.util.HashMap;

public class QualifiersBuilder {
    private HashMap<String, String> qualifiers;

    public QualifiersBuilder(){
        this.qualifiers = new HashMap<>();
    }

    public static QualifiersBuilder startQueuingQualifiers(){
        return new QualifiersBuilder();
    }

    public QualifiersBuilder withAuthor(String author){
        qualifiers.put(Qualifiers.user.toString(), author);
        return this;
    }

    public QueryQualifier build(){
        return new QueryQualifier(this.qualifiers);
    }
}
