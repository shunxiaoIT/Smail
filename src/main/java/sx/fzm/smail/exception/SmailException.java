package sx.fzm.smail.exception;

public class SmailException extends RuntimeException{
    private Integer code = 9999;
    private Integer httpStatusCode = 500;

    public SmailException(Integer code) {
        this.code = code;
    }

    public SmailException(Integer code, Integer httpStatusCode) {
        this.code = code;
        this.httpStatusCode = httpStatusCode;
    }

    public Integer getCode(){
        return code;
    }

    public Integer getHttpStatusCode(){
        return httpStatusCode;
    }
}
