package preProjectTeam34.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.transaction.annotation.Transactional;
import preProjectTeam34.helper.StubData;
import preProjectTeam34.question.dto.QuestionDto;
import preProjectTeam34.helper.ControllerTestHelper;

//@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;

    private ResultActions postResultActions;
    private QuestionDto.Post post;
    private MvcResult postResult;

    @BeforeEach
    public void init() throws Exception {
        // given
        this.post = (QuestionDto.Post) StubData.MockQuesiton.getRequestBody(HttpMethod.POST);
        String content = gson.toJson(post);
        String url = getUrl();
        this.postResultActions = mockMvc.perform(postRequestBuilder(url, content));
    }


    @Test
    public void postQuestionTest() throws Exception{
        QuestionDto.Post post = new QuestionDto.Post("테스트 제목", "테스트 콘텐츠");

        String content = gson.toJson(post);

        ResultActions actions =
                mockMvc.perform(
                        post("/questions")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
    }
}