package models.works;

public class DeleteService {
    private models.works.WorkDao workDao = new models.works.WorkDao();

    public void delete(long workNo) {

        boolean result = workDao.delete(workNo);

    }
}