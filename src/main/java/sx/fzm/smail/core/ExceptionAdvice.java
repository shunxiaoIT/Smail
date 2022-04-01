package sx.fzm.smail.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sx.fzm.smail.util.CodeConfig;
import sx.fzm.smail.exception.SmailException;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @Autowired
    private CodeConfig codeConfig;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleException(HttpServletRequest request, Exception e) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        log.error("通过url:" + requestUrl + "请求的" + method + "方法执行异常", e);
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            return Result.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        }
        else if (e instanceof SmailException) {
            SmailException exception = (SmailException) e;
            return Result.error(codeConfig.getMessage(exception.getCode()), exception.getHttpStatusCode());
        }
        //TODO shiro不具有权限的异常
        else {
            return Result.error(codeConfig.getMessage(9999), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

}
