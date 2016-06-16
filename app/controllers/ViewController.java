package controllers;

import POJO.DatabasePOJO;
import POJO.View;

/**
 * Created by club on 2016-06-15.
 */
public class ViewController extends AbstractController {

    @Override
    public <T extends DatabasePOJO> T getManagedClass() {
        return (T) new View();
    }
}
