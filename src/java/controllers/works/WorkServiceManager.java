package controllers.works;

import models.works.SaveService;
import models.works.WorkDao;

public class WorkServiceManager {
    public WorkDao workDao() {

        return new WorkDao();
    }

    public SaveService saveService () {

        return new SaveService(workDao());
    }
}
