package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.practicespring.domain.Member;
import practice.practicespring.service.MemberService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {


    // 디펜던시 이젝션
    // 새로운 인스턴스를 생성해서 만들지않고
    // 기존 인스턴스를 전달받아 사용한다.
    // DIE
//    MemberService memberService  = new MemberService();


//    @Test
//    public void memberDuplicate(){
//
//        Member member1 = new Member();
//        Member member2 = new Member();
//
//        member1.setName("a");
//        member2.setName("a");
//
//        memberService.join(member1);
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//
//    }
}
