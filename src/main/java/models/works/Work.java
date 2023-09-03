package models.works;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Work {
    private long workNo;
    private String gid = UUID.randomUUID().toString();
    private long userNo;
    private String userNm;
    private Status status = Status.READY;
    private String subject;
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
