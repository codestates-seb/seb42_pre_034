//package preProjectTeam34.answerBookmark;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import preProjectTeam34.answer.entity.Answer;
//import preProjectTeam34.member.entity.Member;
//
//import javax.persistence.*;
//
////TODO: 타 Entity들과의 관계 설정.
//@NoArgsConstructor
//@Getter
//@Entity
//public class AnswerBookmark {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long answerBookmarkId;
//
//    @JoinColumn(name = "memberId")
//    private Member member;
//
//    @JoinColumn(name = "answerId")
//    private Answer answer;
//}
