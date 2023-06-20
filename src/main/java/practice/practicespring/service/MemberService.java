package practice.practicespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.practicespring.domain.Member;
import practice.practicespring.repository.MemberRepository;
import practice.practicespring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){

        /// 중복 회원 검증 코드
        validateDuplicate(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName())
          .ifPresent(m->{
            throw new IllegalStateException("already exist");
        });
    }

    public List<Member> findMembers() {

        return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId){

        return memberRepository.findById(memberId);

    }

}
