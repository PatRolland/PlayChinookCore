package POJO;

/**
 * Created by club on 2016-05-31.
 */
public class Data extends DatabasePOJO {

    public static final String Data_Id = "Data_Id";
    public static final String Course_Id = "Course_Id";
    public static final String Data_Type_Cd = "View_Name";
    public static final String Value = "Value";

    public Data() {}

    public Data(Integer dataId, Integer courseId, Integer dataTypeCd, Float valeur) {
        setDataId(dataId);
        setCourseId(courseId);
        setDataTypeCd(dataTypeCd);
        setValue(valeur);
    }

    public Integer getDataId() {
        return getInteger(Data_Id);
    }

    public void setDataId(Integer dataId) {
        mapIt(Data_Id, dataId);
    }

    public Integer getCourseId() {
        return getInteger(Course_Id);
    }

    public void setCourseId(Integer courseId) {
        mapIt(Course_Id, courseId);
    }

    public Integer getDataTypeCd() {
        return getInteger(Data_Type_Cd);
    }

    public void setDataTypeCd(Integer dataTypeCd) { mapIt(Data_Type_Cd, dataTypeCd);  }

    public Float getValue() { return getFloat(Value); }

    public void setValue(Float value) { mapIt(Value, value); }

    public static String getTableName() {
        return "Data";
    }

    public static String getPrimaryKeyName() {
        return Data_Id;
    }

    public static String getParentName() {
        return Course_Id;
    }
}
