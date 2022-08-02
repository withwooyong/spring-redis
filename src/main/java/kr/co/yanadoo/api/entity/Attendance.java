package kr.co.yanadoo.api.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Attendance {
    private long seq;
    private int userSeq;
    private String attendanceDate;
    private String recentYn;
    private LocalDateTime registDate;
}
