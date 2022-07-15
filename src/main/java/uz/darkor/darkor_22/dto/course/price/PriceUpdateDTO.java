package uz.darkor.darkor_22.dto.course.price;

import uz.darkor.darkor_22.dto.GenericDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public class PriceUpdateDTO extends GenericDTO {

    @NotBlank(message = "price cannot be null or empty")
    @PositiveOrZero(message = "price must be equal to 0 or positive")
    @Pattern(regexp = "\\d",message = "input can include only digits")
    private Double price;

    @NotBlank(message = "uz offer cannot be null or empty")
    private List<String> offersUz;

    @NotBlank(message = "ru offer cannot be null or empty")
    private List<String> offersRu;

    @NotBlank(message = "en offer cannot be null or empty")
    private List<String> offersEn;

}
