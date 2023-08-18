package models.works;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;

public class InfoService {
    private WorkDao workDao = new WorkDao();

    public Work get(long workNo) {

        Work work  = workDao.get(workNo);
        return work;
    }
}
