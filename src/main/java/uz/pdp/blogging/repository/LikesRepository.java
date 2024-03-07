package uz.pdp.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.blogging.entity.Likes;

public interface LikesRepository extends JpaRepository<Likes, Long> {
}