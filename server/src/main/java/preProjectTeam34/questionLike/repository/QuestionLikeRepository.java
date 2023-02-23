package preProjectTeam34.questionLike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.questionLike.entity.QuestionLike;

import java.util.Optional;

@Repository
public interface QuestionLikeRepository extends JpaRepository<QuestionLike, Long> {
    Optional<QuestionLike> findByMemberAndQuestion(Member member, Question question);
}
