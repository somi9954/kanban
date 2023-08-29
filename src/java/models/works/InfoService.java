package models.works;

public class InfoService {
    private models.works.WorkDao workDao = new models.works.WorkDao();

    public models.works.Work get(long workNo) {

        models.works.Work work = workDao.get(workNo);

        return work;
    }
}
