package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StoreRequestDTO {

    @Getter
    public static class RegisterDTO{

        @NotBlank
        String name;

        @Size(min = 1, max = 30)
        String address;

        @NotNull
        Float score;

        @NotNull
        Long regionId;
    }
}