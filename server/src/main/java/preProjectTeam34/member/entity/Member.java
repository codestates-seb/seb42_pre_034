package preProjectTeam34.member.entity;

import lombok.*;
import preProjectTeam34.audit.Auditable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickName;

    // 추후 Address 클래스로 받을 생각임, Frontend에서 어떻게 넘겨줄지에 따라 바뀔듯
    @Column
    private String address;

    @Column(length = 300)
    private String aboutMe;

    @Column
    private String picture;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @Column(length = 30, nullable = false)
    private MemberStatus memberStatus;

    // 회원 로그인의 경로가 어디인지 파악하기 위한 Status
    public enum MemberStatus {
        SESSION_LOGIN("세션 로그인"),
        GOOGLE_LOGIN("구글 로그인"),
        NAVER_LOGIN("네이버 로그인"),
        KAKAO_LOGIN("카카오 로그인");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum Role {
        GUEST("ROLE_GUEST", "GUEST"),
        USER("ROLE_USER", "USER"),
        ADMIN("ROLE_ADMIN", "ADMIN");

        private final String key;
        private final String title;
    }


}
