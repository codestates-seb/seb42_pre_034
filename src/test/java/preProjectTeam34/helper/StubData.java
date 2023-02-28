package preProjectTeam34.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import preProjectTeam34.question.dto.QuestionDto;
import preProjectTeam34.question.entity.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StubData {
//    private static Map<HttpMethod, Object> stubRequestBody;
//    static {
//        stubRequestBody = new HashMap<>();
//        stubRequestBody.put(HttpMethod.POST, new QuestionDto.Post("테스트 제목", "테스트 콘텐츠"));
//        stubRequestBody.put(HttpMethod.PATCH, new QuestionDto.Patch(1, "테스트 제목", "테스트 콘텐츠", Question.QuestionStatus.QUESTION_REGISTRATION));
//    }

    public static class MockQuesiton {
//        public static Object getRequestBody(HttpMethod method) {
//            return stubRequestBody.get(method);
//        }

//        public static QuestionDto.Response getSingleResponseBody() {
//            return new QuestionDto.Response(1L,
//                    "테스트 제목",
//                    "테스트 콘텐츠",
//                    0,
//                    Question.QuestionStatus.QUESTION_REGISTRATION);
//        }

//        public static List<QuestionDto.Response> getMultiResponseBody() {
//            return List.of(
//                    new QuestionDto.Response(1L,
//                            "테스트 제목1",
//                            "테스트 콘텐츠1",
//                            0,
//                            Question.QuestionStatus.QUESTION_REGISTRATION),
//                    new QuestionDto.Response(2L,
//                            "테스트 제목2",
//                            "테스트 콘텐츠2",
//                            10,
//                            Question.QuestionStatus.QUESTION_REGISTRATION)
//            );
//        }

//        public static Question getSingleResultQuestion() {
//            Question question = new Question("테스트 제목", "테스트 타이틀");
//            question.setQuestionStatus(Question.QuestionStatus.QUESTION_REGISTRATION);
//
//            return question;
//        }
//
//        public static Page<Question> getMultiResultQuestions() {
//            Question question1 = new Question("테스트 제목1", "테스트 타이틀1");
//            question1.setQuestionStatus(Question.QuestionStatus.QUESTION_REGISTRATION);
//
//            Question question2 = new Question("테스트 제목2", "테스트 타이틀2");
//            question2.setQuestionStatus(Question.QuestionStatus.QUESTION_REGISTRATION);
//
//            return new PageImpl<>(List.of(question1, question2),
//                    PageRequest.of(0, 15, Sort.by("questionId").descending()),
//                    2);
//        }
//
//        public static Question getSingleResultQuestion(long questionId) {
//            Question question = new Question("테스트 제목", "테스트 타이틀");
//            question.setQuestionId(1L);
//            question.setQuestionStatus(Question.QuestionStatus.QUESTION_REGISTRATION);
//
//            return question;
//        }
//
//        public static Question getSingleResultQuestion(long questionId, Map<String, String> updatedInfo) {
//            String title = Optional.ofNullable(updatedInfo.get("title")).orElse("테스트 제목");
//            String content = Optional.ofNullable(updatedInfo.get("content")).orElse("테스트 콘텐츠");
//            Question question = new Question(title, content);
//            question.setQuestionId(questionId);
//            question.setQuestionStatus(Question.QuestionStatus.QUESTION_REGISTRATION);
//
//            return question;
//        }
    }
}
