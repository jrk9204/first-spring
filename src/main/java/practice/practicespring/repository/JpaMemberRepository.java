package practice.practicespring.repository;

import jakarta.persistence.EntityManager;
import practice.practicespring.domain.Member;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {

        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList().stream().findAny();
    }


//    control + T = inline variable 코드를 단축화 시켜준다.
    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
               .getResultList();
    }
}
