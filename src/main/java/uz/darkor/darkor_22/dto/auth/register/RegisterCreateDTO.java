package uz.darkor.darkor_22.dto.auth.register;

import lombok.*;
import uz.darkor.darkor_22.dto.BaseDTO;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCreateDTO implements BaseDTO {
    @NotBlank(message = "first name cannot be null")
    private String firstName;
    @NotBlank(message = "last name cannot be null")
    private String lastName;
    @NotBlank(message = "father name cannot be null")
    private String fatherName;
    @NotBlank(message = "phone number cannot be null")
    private String phoneNumber;
    @NotBlank(message = "course name cannot be null")
    private String courseName;
}
