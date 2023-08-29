package testdao;

import models.works.SaveService;
import models.works.Status;
import models.works.Work;
import models.works.WorkDao;

public class Ex02 {
    public static void main(String[] args) {
        WorkDao workDao = new WorkDao();
        SaveService saveService = new SaveService(workDao);
        Work work = new Work();
        work.setStatus(Status.PROGRESS);
        work.setSubject("작업 제목...");
        work.setContent("작업 내용...");

        saveService.save(work);
    }
}
