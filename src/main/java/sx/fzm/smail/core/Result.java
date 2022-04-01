package sx.fzm.smail.core;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", HttpStatus.OK);
        put("message", "success");
    }

    public static Result error(String message, Integer code) {
        Result result = new Result();
        result.put("code", code);
        result.put("message", message);
        return result;
    }

    public static Result ok(String message) {
        Result result = new Result();
        result.put("message", message);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
