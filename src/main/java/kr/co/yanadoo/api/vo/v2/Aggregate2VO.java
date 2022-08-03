package kr.co.yanadoo.api.vo.v2;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Aggregate2VO {

    private int userSeq;

    private int studyGroupUserSeq;

    private int totalAssetCount;

    private int totalMediaCount;

    private int totalMissionCount;

    private int totalEnglishMissionCount;

    private int totalActiveMissionCount;

    private int totalLectureCount;

    private int completeAssetCount;

    private int completeMediaCount;

    private int completeMissionCount;

    private int completeEnglishMissionCount;

    private int completeActiveMissionCount;

    private int completeLectureCount;

    private int mediaCompleteLectureCount;

    private int progressRate;

    private int achievementRate;

    private int mediaProgressRate;

    private int mediaAchievementRate;

    private int missionAchievementRate;
}
