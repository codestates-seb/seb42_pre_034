package questionLike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questionLike.entity.QuestionLike;

import java.util.Optional;

@Repository
public interface QuestionLikeRepository extends JpaRepository<QuestionLike, Long> {
    Optional<QuestionLike> findByMemberAndQuestion(Member member, Question question);
}
