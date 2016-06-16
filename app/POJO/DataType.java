package POJO;

/**
 * Created by club on 2016-05-31.
 */
public class DataType extends DatabasePOJO {

    public static final String Data_Type_Cd = "View_Name";
    public static final String Unit_Symbol = "Unit_Symbol";
    public static final String Unit_Name = "Unit_Name";

    public DataType() {}

    public Integer getDataTypeCd() {
        return getInteger(Data_Type_Cd);
    }

    public void setDataTypeCd(Integer dataTypeCd) {
        mapIt(Data_Type_Cd, dataTypeCd);
    }

    public String getUnitSymbol() {
        return getString(Unit_Symbol);
    }

    public void setUnitSymbol(String unitSymbol) { mapIt(Unit_Symbol, unitSymbol); }

    public String getUnitName() {
        return getString(Unit_Name);
    }

    public void setUnitName(String unitName) {
       mapIt(Unit_Name, unitName);
    }

    public static String getTableName() {
        return "Data_Type";
    }

    public static String getPrimaryKeyName() {
        return Data_Type_Cd;
    }
}
