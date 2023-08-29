package models.works;

public class InfoService {
    private WorkDao workDao;

    public void setWorkDao(WorkDao workDao) {
        this.workDao = workDao;
    }

    public Work get(long workNo) {

       Work work = workDao.get(workNo);

        return work;
    }
}
