package practice.practicespring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.practicespring.repository.JdbcMemberRepository;
import practice.practicespring.repository.MemberRepository;
import practice.practicespring.repository.MemoryMemberRepository;
import practice.practicespring.service.MemberService;

import javax.sql.DataSource;



// 객체지향, 다형성 사용에좋다 - 스프링

// 인터페이스에서 코드 수정안해도 변경이 가능하다.



@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }

}