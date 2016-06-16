package controllers;

import POJO.Command;
import POJO.DatabasePOJO;

/**
 * Created by club on 2016-06-15.
 */
public class CommandController extends AbstractController {
    @Override
    public <T extends DatabasePOJO> T getManagedClass() {
        return (T) new Command();
    }
}
