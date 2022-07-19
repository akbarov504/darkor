package uz.darkor.darkor_22.dto.auth.register;

import lombok.*;
import uz.darkor.darkor_22.dto.GenericDTO;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterGetDTO extends GenericDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String phoneNumber;
    private String courseName;
}
