package top.tbz.config.model;


import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Component
@Validated
public class Team {
    @Value("web2班")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min =3,max=20)
    private String name;

    @Value("tbz")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min =3,max=8)
    private String leader;

    @Value("${Team.age}")
    @Min(1)
    @Max(4)
    private Integer age;

    @Value("${Team.phone}")
    private String phone;

    private LocalDate createTime;
}
