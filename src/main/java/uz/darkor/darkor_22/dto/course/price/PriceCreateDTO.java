package uz.darkor.darkor_22.dto.course.price;

import lombok.Getter;
import lombok.Setter;
import uz.darkor.darkor_22.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
public class PriceCreateDTO implements BaseDTO {

    @NotBlank(message = "price cannot be null or empty")
    @PositiveOrZero(message = "price must be equal to 0 or positive")
    @Pattern(regexp = "\\d", message = "input can include only digits")
    private Double price;

    @NotBlank(message = "uz offer cannot be null or empty")
    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private List<String> offersUz;

    @NotBlank(message = "ru offer cannot be null or empty")
    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private List<String> offersRu;

    @NotBlank(message = "en offer cannot be null or empty")
    @Size(min = 3, max = 255, message = "The length of the name field must be between 3 and 255")
    private List<String> offersEn;
}
