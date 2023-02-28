package preProjectTeam34.questionBookmark.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.questionBookmark.entity.QuestionBookmark;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionBookmarkRepository extends JpaRepository<QuestionBookmark, Long> {

        Page<QuestionBookmark> findByMemberId(Long memberId, Pageable pageable);
        Optional<QuestionBookmark> findByMemberIdAndQuestionId(Long memberId, Long questionId);
}
