/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.sql.*;

/**
 *
 * @author agach
 */
public class Database {
    private static Database instantaBD;
    private static Connection conn;
    private Database() {
        
    }
    public static Database getInstance() {
        if(instantaBD == null) {
            instantaBD = new Database();
        }
        return instantaBD;
    }
    
    public Connection getConnection() {
        try {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            String serverName = "localhost";
            String serverPort = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;
            String username = "dba";
            String password = "sql";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectare reusita!");
        } catch (ClassNotFoundException e) {
            System.out.println("Eroare la driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Eroare la conexiune " + e.getMessage());
        }
        return conn;
    }
}
