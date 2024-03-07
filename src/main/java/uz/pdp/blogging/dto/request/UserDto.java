package uz.pdp.blogging.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.blogging.entity.User;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;

    public UserDto (User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
