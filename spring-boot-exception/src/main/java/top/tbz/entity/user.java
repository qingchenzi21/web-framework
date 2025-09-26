package top.tbz.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.tbz.annotation.Phone;

@Data
public class user {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Max(value = 100,message = "年龄不能大于100")
    @Min(value = 0,message = "年龄不能小于0")
    private int age;

    @NotBlank(message = "手机号不能为空")
    @Phone
    private String phone;
}
