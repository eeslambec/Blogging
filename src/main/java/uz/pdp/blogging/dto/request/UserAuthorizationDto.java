package uz.pdp.blogging.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAuthorizationDto {
    private String username;
    private String email;
    private String password;

}
