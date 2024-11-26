/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Omar Rafael
 */
public class Mysql {
    private Connection connection;

    public Mysql() {
    }

    public Connection getConnection() {

        String databaseName="escuela";
        String databaseUser="root";
        String databasePassword="";
        String url="jdbc:mysql://localhost:3307/"+databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,databaseUser,databasePassword);
            //System.out.println("connection Succesful");
        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("conecctuion dead");
        }
        return connection;
    }
    
    public static void main(String[] args) {
        Mysql conn=new Mysql();
        conn.getConnection();
    }

}
