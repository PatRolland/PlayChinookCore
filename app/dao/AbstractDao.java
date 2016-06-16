package dao;

import JDBC.ConnectionPostgreSQL;
import POJO.DatabasePOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by club on 2016-06-01.
 */
public class AbstractDao {

    enum REQUESTS { READ, LIST, UPDATE, CREATE, DELETE };

    static Connection conn = ConnectionPostgreSQL.getInstance();

    public static < T extends DatabasePOJO > T get(Integer id, T pojo) {
        return get(id, null, pojo);
    }

    public static < T extends DatabasePOJO > T get(Integer id, String where, T pojo) {
       return doRequest(fetchRequest(id, pojo, REQUESTS.READ));
    }

    public static < T extends DatabasePOJO > T update(Integer id, T pojo) {
        return update(id, null, pojo);
    }

    public static < T extends DatabasePOJO > T update(Integer id, String where, T pojo) {
        return doRequest(fetchRequest(id, pojo, REQUESTS.UPDATE));
    }

    public static < T extends DatabasePOJO > T create(Integer id, T pojo) {
        return create(id, null, pojo);
    }

    public static < T extends DatabasePOJO > T create(Integer id, String where, T pojo) {
        return doRequest(fetchRequest(id, pojo, REQUESTS.CREATE));
    }

    public static < T extends DatabasePOJO > T delete(Integer id, T pojo) {
        return delete(id, null, pojo);
    }

    public static < T extends DatabasePOJO > T delete(Integer id, String where, T pojo) {
        return doRequest(fetchRequest(id, pojo, REQUESTS.DELETE));
    }

    public static < T extends DatabasePOJO > List<T> list(Integer parentId, T pojo) {
        List<T> objects = new ArrayList<T>();
        String request = fetchRequest(parentId, pojo, REQUESTS.LIST);

        try {
            PreparedStatement ps = conn.prepareStatement(request);
            ResultSet rs = ps.executeQuery();




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }


    private static < T extends DatabasePOJO > T doRequest(String request) {
        try {
            PreparedStatement ps = conn.prepareStatement(request);
            ResultSet rs = ps.executeQuery();




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static < T extends DatabasePOJO > String fetchRequest(Integer id, T pojo, REQUESTS r) {

        String request = null;
        switch (r) {
            case READ:
                request = DatabasePOJO.getReadStatement(id, pojo);
                break;
            case UPDATE:
                request = DatabasePOJO.getUpdateStatement(id, pojo);
                break;
            case CREATE:
                request = DatabasePOJO.getInsertStatement(pojo);
                break;
            case LIST:
                if(id != null) {
                    request = DatabasePOJO.getListStatement(id, pojo);
                }
                break;
        }

        return request;
    }

    public < T extends DatabasePOJO > void buildPOJOFromResultSet(T pojo, ResultSet rs) throws SQLException {
        for(Map.Entry<String, Object> entry : pojo.databaseMap.entrySet()) {
            Object value = rs.getObject(entry.getKey());
            entry.setValue(value);
        }
    }
}
