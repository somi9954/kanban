package models.works;

import validators.Validator;

public class SaveService {
    private WorkDao workDao;
    private Validator<Work> validator;
    public SaveService(WorkDao workDa, Validator<Work> validator) {
        this.workDao = workDao;
        this.validator = validator;
    }

    public void save(Work work) {
        // 유효성 검사
      validator.check(work);

      boolean result = workDao.save(work);
      if(!result) { // 등록 실패
        throw new WorkSaveException();
      }
    }
}
