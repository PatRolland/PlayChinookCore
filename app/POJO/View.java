package POJO;

/**
 * Created by club on 2016-06-02.
 */
public class View extends DatabasePOJO {

    public static final String View_Id = "View_Id";

    public static final String View_Name = "View_Name";

    public static final String Command_View_Fg = "Command_View_Fg";

    public Integer getVueId() { return getInteger(View_Id); }

    public void setVueId(Integer id) { mapIt(View_Id, id); }

    public String getViewName() {
        return getString(View_Name);
    }

    public void setViewName(String viewName) {
        mapIt(View_Name, viewName);
    }

    public Boolean getCommandViewFg() { return getBoolean(Command_View_Fg); }

    public void setCommandViewFg(Boolean fg) { mapIt(Command_View_Fg, fg); }


    public static String getTableName() {
        return "View";
    }

    public static String getPrimaryKeyName() {
        return View_Id;
    }
}
