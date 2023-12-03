package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDto{

        @NotNull
        Long memberId;

        @NotNull
        String title;

        @NotNull
        Float score;

    }
}