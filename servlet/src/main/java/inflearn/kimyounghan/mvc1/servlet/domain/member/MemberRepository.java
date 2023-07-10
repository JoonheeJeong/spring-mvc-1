package inflearn.kimyounghan.mvc1.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static final MemberRepository INSTANCE = new MemberRepository();

    private static long seq = 0L;

    private Map<Long, Member> memberMap = new HashMap<>();

    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        return INSTANCE;
    }

    public Member save(Member member) {
        member.setId(++seq);
        memberMap.put(seq, member);
        return member;
    }

    public Member findById(Long id) {
        return memberMap.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(memberMap.values());
    }

    public void clear() {
        memberMap.clear();
    }


}
