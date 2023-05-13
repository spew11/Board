package eunjilee.boardwithjpa.service;

import eunjilee.boardwithjpa.dto.MemberDTO;
import eunjilee.boardwithjpa.entity.MemberEntity;
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
        memberDTO.setPassword(encoder.encode(memberDTO.getPassword()));
        MemberEntity memberEntity = new MemberEntity(memberDTO.getEmail(), memberDTO.getNickName(), memberDTO.getPassword());
        memberRepository.save(memberEntity);
        return memberEntity.getEmail();
    }

    public MemberEntity login(MemberDTO memberDTO) {
        MemberEntity memberEntity = findOneByEmail(memberDTO.getEmail());
        if (memberEntity != null) {
            if (encoder.matches(memberDTO.getPassword(), memberEntity.getPassword())) {
                return memberEntity;
            }
        }
        return null;
    }

    public MemberEntity findOneByEmail(String memberEmail) {
        Optional<MemberEntity> selected = memberRepository.findOne(memberEmail);
        return memberRepository.findOne(memberEmail).orElse(null);
    }
}
