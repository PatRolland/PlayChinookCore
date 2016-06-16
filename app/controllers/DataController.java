package controllers;

import POJO.Data;
import POJO.DatabasePOJO;

/**
 * Created by club on 2016-06-15.
 */
public class DataController extends AbstractController {
    @Override
    public <T extends DatabasePOJO> T getManagedClass() {
        return (T) new Data();
    }
}
