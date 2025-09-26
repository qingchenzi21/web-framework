package top.tbz1.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.tbz1.exception.ServerException;
import top.tbz1.result.Result;

/**
 * @Author: tbz
 * @Date: 2025/9/19
 * @Description: 业务异常处理器
 * AOP 切面处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHander {

    /**
     * 处理业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServerException.class)
    public Result<String> handleBusinessException(ServerException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理其他异常
     *
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {

        log.error(e.getMessage(), e
        );
    }
}
