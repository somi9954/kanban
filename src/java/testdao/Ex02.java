package testdao;

import controllers.works.WorkServiceManager;
import models.works.SaveService;
import models.works.Status;
import models.works.Work;
import models.works.WorkDao;

public class Ex02 {
    public static void main(String[] args) {
        SaveService saveService = WorkServiceManager.getInstance().saveService();

        Work work = new Work();
        work.setWorkNo(3L);
        work.setStatus(Status.PROGRESS);
        work.setSubject("(수정)작업 제목...");
        work.setContent("(수정)작업 내용...");

        try {
            saveService.save(work);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        }
}
