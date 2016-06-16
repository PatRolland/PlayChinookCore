package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by prolland on 2016-06-01.
 * Code from http://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-donnees-avec-pattern-dao/
 */
public class ConnectionPostgreSQL{

    /**
     * URL de connection
     */
    private static String url = "jdbc:postgresql://localhost:5432/Chinook";
    /**
     * Nom du user
     */
    private static String user = "prolland";
    /**
     * Mot de passe du user
     */
    private static String passwd = "prolland";
    /**
     * Objet Connection
     */
    private static Connection connect;

    /**
     * Méthode qui va nous retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
     */
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
