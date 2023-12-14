package br.edu.ifnmg.poo.trabalhos.datapersistence.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 *
 */
public class ConnectionDao {

    public static Connection conectaBD() {
        Connection conn = null;

        String dbName = "alphasystem";

        try {
            String url = "jdbc:mysql://localhost:3306/" + dbName + "?user=root&password=";
            conn = DriverManager.getConnection(url);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DAO/ConnectionDAO: " + erro.getMessage());
        }
        return conn;
    }
}
