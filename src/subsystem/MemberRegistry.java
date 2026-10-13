package subsystem;

import model.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberRegistry {
    private final List<Member> members = new ArrayList<>();

    public MemberRegistry() {
        members.add(new Member(1, "Student1", true));
        members.add(new Member(2, "Student2", true));
        members.add(new Member(3, "Student3", false));
    }

    public Member findMember(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId)
                return member;
        }
        return null;
    }

    public boolean isEligible(int memberId) {
        Member member = findMember(memberId);
        return member != null && member.isActive();
    }
}