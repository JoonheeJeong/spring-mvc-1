package inflearn.kimyounghan.mvc1.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clear(); 
    }

    @Test
    void save() {
        Member member = new Member("UserA", 20);

        Member savedMember = memberRepository.save(member);

        assertThat(savedMember).isSameAs(member);
        assertThat(savedMember.getUsername()).isEqualTo("UserA");
        assertThat(savedMember.getAge()).isEqualTo(20);
    }

    @Test
    void findAll() {
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        Member member3 = new Member("member3", 25);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(3);
        assertThat(members).contains(member1, member2, member3);
    }

}