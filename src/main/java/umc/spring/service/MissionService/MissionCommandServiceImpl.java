package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission challengeMission(MissionRequestDTO.ChallengeDto requestDto) {
        Store store = storeRepository.findById(requestDto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 없습니다. id=" + requestDto.getStoreId()));

        Member member = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + requestDto.getMemberId()));

        Mission mission = Mission.builder()
                .missionStatus(requestDto.getMissionStatus())
                .reward(requestDto.getReward())
                .deadline(requestDto.getDeadline())
                .missionSpec(requestDto.getMissionSpec())
                .store(store)
                .member(member)
                .build();

        missionRepository.save(mission);

        return mission;
    }

    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return memberRepository.existsById(id);
    }

}