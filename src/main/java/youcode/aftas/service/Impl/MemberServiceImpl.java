package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import youcode.aftas.service.MemberService;
import youcode.aftas.domain.Member;
import youcode.aftas.repository.MemberRepository;
import java.util.List;
@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }
    @Override
    public List<Member> searchMember(String name) {
        return memberRepository.findByName(name);
    }
    @Override
    public Member updateMember(Member member, Long id) {
        Member existingMember = getMemberById(id);
        existingMember.setName(member.getName());
        existingMember.setFamilyName(member.getFamilyName());
        existingMember.setAccessDate(member.getAccessDate());
        existingMember.setNationality(member.getNationality());
        existingMember.setIdentityDocumentType(member.getIdentityDocumentType());
        existingMember.setIdentityNumber(member.getIdentityNumber());
        return memberRepository.save(existingMember);
    }
    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}
