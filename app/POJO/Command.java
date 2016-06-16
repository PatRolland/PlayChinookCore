package POJO;

/**
 * Created by club on 2016-05-31.
 */
public class Command extends DatabasePOJO {
    public static final String Command_Id = "Command_Id";
    public static final String Code_Command = "Code_Command";
    public static final String View_Id = "View_Id";

    public Command() {};

    public Integer getCommandeId() {
        return getInteger(Command_Id);
    }

    public void setCommandeId(Integer commandeId) {
        mapIt(Command_Id, commandeId);
    }

    public String getCodeCommande() {
        return getString(Code_Command);
    }

    public void setCodeCommande(String codeCommande) {
        mapIt(Code_Command, codeCommande);
    }

    public String getViewId() {
        return getString(View_Id);
    }

    public void setViewId(String viewId) {
        mapIt(View_Id, viewId);
    }

    public static String getTableName() {
        return "Commande";
    }

    public static String getPrimaryKeyName() {
        return Command_Id;
    }
}
