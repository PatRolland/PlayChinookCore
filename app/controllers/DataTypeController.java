package controllers;

import POJO.DataType;
import POJO.DatabasePOJO;

/**
 * Created by club on 2016-06-15.
 */
public class DataTypeController extends AbstractController {
    @Override
    public <T extends DatabasePOJO> T getManagedClass() {
        return (T) new DataType();
    }
}
