//package preProjectTeam34.answer;
//
//
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import preProjectTeam34.answer.dto.AnswerPatchDto;
//import preProjectTeam34.answer.dto.AnswerPostDto;
//import preProjectTeam34.utils.UriCreator;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequestMapping("/answers")
//@Validated
//public class AnswerController {
//    //TODO: 필드들 추가.
//    private final static String Answer_DEFAULT_URL = "/answers";
//
//    private final AnswerService answerService;
//    private final AnswerMapper mapper;
//
//
//    public AnswerController(AnswerService answerService, AnswerMapper mapper) {
//        this.answerService = answerService;
//        this.mapper = mapper;
//    }
////TODO: Path variable, validation 추가.
//    @PostMapping
//    public ResponseEntity postAnswer(@RequestBody AnswerPostDto answerPostDto) {
//        Answer answer = answerService.createAnswer(mapper.answerPostDtoToAnswer(answerPostDto));
//        URI location = UriCreator.createUri(Answer_DEFAULT_URL, answer.answerId());
//
//        return ResponseEntity.created(location).build();
//    }
//    @PatchMapping
//    public ResponseEntity patchAnswer(@PathVariable long answerId,
//                                      @RequestBody AnswerPatchDto answerPatchDto) {
//        answerPatchDto.setAnswerId(answerId);
//        Answer answer =
//                answerService.updateAnswer(mapper.answerPatchDtoToAnswer(answerPatchDto));
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer))
//                , HttpStatus.OK);
//    }
//    @GetMapping("/{answer-id}")
//    public ResponseEntity getAnswer(@PathVariable("answer-id") long answerId) {
//        Answer answer = answerService.findAnswer(answerId);
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer)),
//                HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity getAnswers(@RequestParam int page,
//                                     @RequestParam int size) {
//        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
//        List<Answer> answers = pageAnswers.getContent();
//
//        return new ResponseEntity<>(
//                new MultiResponseDto<>(mapper.answersToAnswerResponseDtos(answers), pageAnswers),
//                HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{answer-id}")
//    public ResponseEntity cancelAnswer(@PathVariable("answer-id") long answerId) {
//        answerService.cancelAnswer(answerId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
//
