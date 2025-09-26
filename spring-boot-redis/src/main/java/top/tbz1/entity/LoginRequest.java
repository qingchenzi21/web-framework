package top.tbz1.entity;

import lombok.Data;

/**
 * @author kimihiro
 */
@Data
public class LoginRequest {
    private String phone;
    private String code;
}
