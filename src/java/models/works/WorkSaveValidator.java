package models.works;

import validators.Validator;

public class WorkSaveValidator implements Validator<Work> {
    @Override
    public void check(Work work) {
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
    }
}
