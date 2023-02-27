package preProjectTeam34.member.dto;

import lombok.Builder;
import lombok.Getter;

public class MemberDtoImpl implements MemberDto{
    @Getter
    @Builder
    public static class Response{
        private long memberId;
        private String email;
        private String name;
        private String picture;
    }
}
