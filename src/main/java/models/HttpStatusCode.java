package models;

public enum HttpStatusCode {
    SUCCESS(200),
    UNPROCESSABLE_ENTITY(422);
    private int code;
    HttpStatusCode(final int code){
        this.code = code;
    }
    public int code(){return code;}
}
