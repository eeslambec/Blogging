package uz.pdp.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.blogging.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}