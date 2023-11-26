package userApi.src.main.java.com.github.userApi.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(IgnoreUnknown = true )
public class AtualizarUserRequest {
    private Long id;
    private String name;
    private int age;
}
