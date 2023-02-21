package preProjectTeam34.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import preProjectTeam34.question.entity.Question;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByQuestion(long questionId);
}
