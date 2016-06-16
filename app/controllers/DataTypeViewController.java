package controllers;

import POJO.DataTypeView;
import POJO.DatabasePOJO;

/**
 * Created by club on 2016-06-15.
 */
public class DataTypeViewController extends AbstractController {
    @Override
    public <T extends DatabasePOJO> T getManagedClass() {
        return (T) new DataTypeView();
    }
}
