package preProjectTeam34.tags.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

public class TagsDto {

    @Getter
    @Setter
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public static class Response{
        private Long tagsId;

        private String name;
        private String content;
    }
}
