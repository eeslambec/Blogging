package uz.pdp.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.blogging.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}