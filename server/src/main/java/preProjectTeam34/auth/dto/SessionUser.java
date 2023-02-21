package preProjectTeam34.auth.dto;

import lombok.Getter;
import preProjectTeam34.member.entity.Member;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String nickName;
    private String email;
    private String picture;

    public SessionUser(Member member){
        this.nickName = member.getNickName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
    }
}
