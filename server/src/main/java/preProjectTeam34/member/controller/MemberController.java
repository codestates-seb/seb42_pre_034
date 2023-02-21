package preProjectTeam34.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import preProjectTeam34.member.dto.MemberDto;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.member.mapper.MemberMapper;
import preProjectTeam34.member.service.MemberService;
import preProjectTeam34.utils.UriCreator;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
@Validated
@Slf4j
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/users";
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody){
        Member member = memberMapper.memberPostDtoToMember(requestBody);

        Member createdMember = memberService.createMember(member);
        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getMemberId(), createdMember.getNickName());

        return ResponseEntity.created(location).build();
    }
}
