package models.works;

public class SaveService {
    private WorkDao workDao;

    public SaveService(WorkDao workDao) {
        this.workDao = workDao;
    }

    public void save(Work work) {

        /** 필수 항목 검증 - status, subject, content */
        if (work.getStatus() == null) {
            throw new WorkValidationException("작업 상태를 선택하세요.");
        }
        String subject = work.getSubject();
        if (subject == null || subject.isBlank()) {
            throw new WorkValidationException("작업 제목을 입력하세요.");
        }

        String content = work.getContent();
        if (content == null || content.isBlank()) {
            throw new WorkValidationException("작업 내용을 입력하세요");
        }

        workDao.save(work); // 의존

    }
}
