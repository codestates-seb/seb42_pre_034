package preProjectTeam34.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import preProjectTeam34.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
