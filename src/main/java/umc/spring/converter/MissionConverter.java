package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(Mission mission){
        if (mission.getMember() == null) {
            throw new IllegalArgumentException("Member is null in mission");
        }
        return MissionResponseDTO.ChallengeResultDTO.builder()
                .memberId(mission.getMember().getId())
                .missionStatus(mission.getMissionStatus())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.ChallengeDto request, Store store, Member member){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .member(member)
                .build();
    }
}