package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import java.beans.Transient;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by club on 2016-05-31.
 */
public abstract class DatabasePOJO {
    @JsonIgnore
    public transient HashMap<String, Object> databaseMap = new HashMap<String, Object>();

    public static <T extends DatabasePOJO> String getReadStatement(Integer id, T pojo) {
        return "Select * from " + pojo.getTableName() + " where " + pojo.getPrimaryKeyName() + " = " + id;
    }

    public static <T extends DatabasePOJO> String getListStatement(Integer parentId, T pojo) {
        String request = "Select * from " + pojo.getTableName();

        if(parentId == null && pojo.getParentName() != null){
            Object parent = pojo.databaseMap.get(pojo.getParentName());
            if(parent != null) {
                if(parent instanceof Integer) {
                    parentId = (Integer) parent;
                }
                else {
                    System.out.println("Parent key is not an integer??? Table: " + pojo.getTableName());
                }
            }
        }
        if (parentId != null) {

            if(pojo.getParentName() == null) {
                System.out.println("Parent Id is not null but the resource has no parent. Table: " + pojo.getTableName());
            }
            request += " where " + pojo.getParentName() + "=" + parentId;
        }

        return request;
    }

    public static <T extends DatabasePOJO> String getListStatement(T pojo) {
        return getListStatement(null, pojo);
    }

    public static <T extends DatabasePOJO> String getInsertStatement(T pojo) {
        String request = "Insert into " + pojo.getTableName() + " (";
        String values = " values (";
        for(Map.Entry<String, Object> entry : pojo.databaseMap.entrySet()) {
            request += entry.getKey() + ",";
            values += entry.getValue() + ",";
        }
        request = request.substring(0, request.length() - 1) + ")";
        values = values.substring(0, values.length() - 1) + ")";
        System.out.println(pojo.databaseMap.toString().substring(1,pojo.databaseMap.toString().length() -1));
        return request + values;
    }

    public static <T extends DatabasePOJO> String getUpdateStatement(Integer id, T pojo) {
        String request = "Update " + pojo.getTableName() + " Set (";
        for(Map.Entry<String, Object> entry : pojo.databaseMap.entrySet()) {
            String valueString = entry.getValue().toString();
            if( entry.getValue() instanceof String) {
                valueString = "'" + valueString + "'";
            }
            request += entry.getKey() + "=" + valueString + ",";
        }
        request = request.substring(0, request.length() - 1) + ") where " + pojo.getPrimaryKeyName() + " = " + id;

        return request;
    }

    public static String getTableName() {
        return null;
    };

    public static String getPrimaryKeyName() {
        return null;
    };

    public static String getParentName() {
        return null;
    };

    protected void mapIt(String databaseColumnName, Object data) {
        databaseMap.put(databaseColumnName, data);
    }

    protected Integer getInteger(String databaseColumnName) {
        try {
            return (Integer) databaseMap.get(databaseColumnName);
        }
        catch (ClassCastException e) {
            System.out.println("Error trying to parse " + databaseColumnName + " to Integer");
            throw e;
        }
        catch (NullPointerException e) {
            System.out.println("Database column name is null");
            throw e;
        }
    }

    protected Float getFloat(String databaseColumnName) {
        try {
            return (Float) databaseMap.get(databaseColumnName);
        }
        catch (ClassCastException e) {
            System.out.println("Error trying to parse " + databaseColumnName + " to Float");
            throw e;
        }
        catch (NullPointerException e) {
            System.out.println("Database column name is null");
            throw e;
        }
    }

    protected String getString(String databaseColumnName) {
        try {
            return (String) databaseMap.get(databaseColumnName);
        }
        catch (ClassCastException e) {
            System.out.println("Error trying to parse " + databaseColumnName + " to String");
            throw e;
        }
        catch (NullPointerException e) {
            System.out.println("Database column name is null");
            throw e;
        }
    }

    protected Boolean getBoolean(String databaseColumnName) {
        try {
            return (Boolean) databaseMap.get(databaseColumnName);
        }
        catch (ClassCastException e) {
            System.out.println("Error trying to parse " + databaseColumnName + " to Boolean");
            throw e;
        }
        catch (NullPointerException e) {
            System.out.println("Database column name is null");
            throw e;
        }
    }

    protected DateTime getDate(String databaseColumnName) {
        try {
            return (DateTime) databaseMap.get(databaseColumnName);
        }
        catch (ClassCastException e) {
            System.out.println("Error trying to parse " + databaseColumnName + " to Date");
            throw e;
        }
        catch (NullPointerException e) {
            System.out.println("Database column name is null");
            throw e;
        }
    }

}
