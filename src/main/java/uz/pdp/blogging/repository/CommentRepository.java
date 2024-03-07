package uz.pdp.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.blogging.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}