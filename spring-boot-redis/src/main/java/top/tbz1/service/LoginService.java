package top.tbz1.service;

import top.tbz1.entity.LoginRequest;
import top.tbz1.entity.LoginResponse;

/**
 * @author kimihiro
 */
public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);

}
