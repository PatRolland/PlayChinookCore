package POJO;


import org.joda.time.DateTime;

/**
 * Created by prolland on 2016-05-31.
 */
public class Course extends DatabasePOJO {

    public static String Course_Id = "Course_Id";
    public static String Date_Course = "Date_Course";

    public Course() {}

    public Course(Integer courseId, String dateCourse) {
        setCourseId(courseId);
        setDateCourse(dateCourse);
    }

    public Integer getCourseId() {
        return getInteger(Course_Id);
    }

    public void setCourseId(Integer courseId) {
        mapIt(Course_Id, courseId);
    }

    public String getDateCourse() {
        return getDate(Date_Course).toString();
    }

    public void setDateCourse(String dateCourse) {
        mapIt(Date_Course, new DateTime(dateCourse));
    }

    public static String getTableName() {
        return "Course";
    }

    public static String getPrimaryKeyName() {
        return Course_Id;
    }
}

