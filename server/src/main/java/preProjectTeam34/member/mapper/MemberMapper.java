package preProjectTeam34.member.mapper;

import org.mapstruct.Mapper;
import preProjectTeam34.member.dto.MemberDto;
import preProjectTeam34.member.dto.MemberDtoImpl;
import preProjectTeam34.member.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post requestBody);
    default MemberDtoImpl.Response memberToMemberResponse(Member member){
        MemberDtoImpl.Response response = MemberDtoImpl.Response.builder()
                .memberId(member.getMemberId())
                .name(member.getNickName())
                .picture(member.getPicture())
                .email(member.getEmail())
                .build();

        return response;
    }
}
