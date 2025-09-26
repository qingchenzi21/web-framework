package top.tbz.service;

import org.springframework.stereotype.Service;
import top.tbz.Exception.BusinessException;


@Service
public class ExceptionService {
    public void unAuthorizeError(){
        throw new BusinessException("权限不足");
    }
    public void systemError(){
        throw new BusinessException("系统异常");
    }
}
