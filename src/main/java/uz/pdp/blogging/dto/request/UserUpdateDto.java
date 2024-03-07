package uz.pdp.blogging.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
}
