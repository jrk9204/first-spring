package practice.practicespring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.practicespring.domain.Member;
import practice.practicespring.service.MemberService;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){

        Member newMember = new Member();
        newMember.setName("Spring");
        repository.save(newMember);
        Member result = repository.findById(newMember.getId()).get();
        assertThat(newMember).isEqualTo(result);
//        Assertions.assertEquals(newMember, null);
    }

    @Test
    public void findByName(){

        Member member1 = new Member();
        Member member2 = new Member();
        
        member1.setName("a");
        member2.setName("b");
        
        repository.save(member1);
        repository.save(member2);

        Member result =  repository.findByName("a").get();

        assertThat(result).isEqualTo(member1);

        List<Member> resultAll = repository.findAll();

        assertThat(resultAll.size()).isEqualTo(2);

    }





}
