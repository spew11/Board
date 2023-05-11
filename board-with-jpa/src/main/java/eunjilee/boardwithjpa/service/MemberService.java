package eunjilee.boardwithjpa.service;

import eunjilee.boardwithjpa.dto.MemberDTO;
import eunjilee.boardwithjpa.entity.Member;
import eunjilee.boardwithjpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    public String join(MemberDTO memberDTO) {
        memberDTO.setMemberPassword(encoder.encode(memberDTO.getMemberPassword()));
        Member member = new Member(memberDTO.getMemberEmail(), memberDTO.getMemberNickName(), memberDTO.getMemberPassword());
        memberRepository.save(member);
        return member.getMemberEmail();
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<Member> aMember = findOne(memberDTO.getMemberEmail());
        if (aMember.isPresent()) {
            if (encoder.matches(memberDTO.getMemberPassword(), aMember.get().getMemberPassword())) {
                return memberDTO;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public Optional<Member> findOne(String memberEmail) {
        return memberRepository.findByEmail(memberEmail);
    }
}
