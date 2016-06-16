package POJO;

/**
 * Created by club on 2016-06-02.
 */
public class DataTypeView extends DatabasePOJO {
    public static String Data_Type_View_Id = "Data_Type_View_Id";
    public static String View_Id = "View_Id";
    public static String Data_Type_Cd = "Data_Type_Cd";

    public DataTypeView() {}

    public DataTypeView(Integer id, Integer viewId, Integer dataType) {
        setDataTypeViewId(id);
        setViewId(viewId);
        setDataTypeCd(dataType);
    }

    public Integer getDataTypeViewId() { return getInteger(Data_Type_View_Id); }

    public void setDataTypeViewId(Integer id) { mapIt(Data_Type_View_Id, id); }

    public Integer getViewId() { return getInteger(View_Id); }

    public void setViewId(Integer viewId) { mapIt(View_Id, viewId); }

    public Integer getDataTypeCd() { return getInteger(Data_Type_Cd); }

    public void setDataTypeCd(Integer dataType) { mapIt(Data_Type_Cd, dataType); }

    public static String getTableName() {
        return "DataTypeView";
    }

    public static String getParentName() {
        return View_Id;
    }

}
