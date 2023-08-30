package models.works;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InfoService {
    private WorkDao workDao;

    public void setWorkDao(WorkDao workDao) {
        this.workDao = workDao;
    }

    public Work get(long workNo) {

       Work work = workDao.get(workNo);

        return work;
    }

    public Map<Status, List<Work>> getList(Work work) {

        List<Work> items = workDao.gets(work);
        if (items == null) return null;

        Map<Status, List<Work>> data = items.stream().collect(Collectors.groupingBy(Work::getStatus));

        return data;
    }
    /** 작업 준비중 목록 */
    public List<Work> getListReady() {
        return  getList(Status.READY);
    }

   public List<Work> getList(Status status) {
        Work work = new Work();
        work.setStatus(status);

        Map<Status, List<Work>> items = getList(work);

        return items == null ? null : items.get(status);
    }
}
