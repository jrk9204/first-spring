package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.practicespring.domain.Member;
import practice.practicespring.service.MemberService;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberService memberService  = new MemberService();


    @Test
    public void memberDuplicate(){

        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("a");
        member2.setName("a");

        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


    }
}
