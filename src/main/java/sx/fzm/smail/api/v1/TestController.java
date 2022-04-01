package sx.fzm.smail.api.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sx.fzm.smail.core.Result;
import sx.fzm.smail.exception.SmailException;

@RestController
@Api("测试接口")
public class TestController {

    @GetMapping("/test")
    @ApiOperation("Hello World")
    public Result test() throws Exception {
        return Result.ok("hello world");
    }

}
