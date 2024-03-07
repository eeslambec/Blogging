package uz.pdp.blogging.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uz.pdp.blogging.entity.enums.Gender;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Gender gender;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> userRoles;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Blog> blogs;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Likes> likedBlogs;
    private boolean status;
}
