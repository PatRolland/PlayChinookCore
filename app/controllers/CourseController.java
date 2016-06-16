package controllers;

import POJO.Course;
import POJO.DatabasePOJO;

/**
 * Created by club on 2016-06-15.
 */
public class CourseController extends AbstractController {

    public <T extends DatabasePOJO> T getManagedClass() {
        return (T) new Course();
    }
}
