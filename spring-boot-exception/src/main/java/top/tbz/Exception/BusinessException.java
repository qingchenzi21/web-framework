package top.tbz.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.tbz.enums.ErrorCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{
    private int code;
    private String msg;

    public BusinessException(String msg) {
        super(msg);
        this.code =ErrorCode.SERVER_ERROR.getCode();
        this.msg=msg;

    }

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public BusinessException(String msg,Throwable e){
        super(msg);
        this.code = ErrorCode.SERVER_ERROR.getCode();
        this.msg=msg;
    }


}
