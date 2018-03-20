/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dlpuertaj
 */
public class InserData {
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
 
        // Get Connection
        Connection connection = ConnectionUtils.getMyConnection();
 
        Statement statement = connection.createStatement();
 
        String sql = "Insert into Salary_Grade (Grade, High_Salary, Low_Salary) "
                + " values (2, 20000, 10000) ";
         
        // Execute statement
        // executeUpdate(String) using for Insert, Update, Delete statement.
        int rowCount = statement.executeUpdate(sql);
             
        System.out.println("Row Count affected = " + rowCount);
    }
}
