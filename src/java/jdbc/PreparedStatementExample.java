/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dlpuertaj
 */
public class PreparedStatementExample {
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
 
        // Get a connection
        Connection connection = ConnectionUtils.getMyConnection();
 
        // Create a SQL statement with two parameters (?)
        String sql = "Select emp.Emp_Id, emp.Emp_No, emp.Emp_Name,"
                + " emp.Dept_Id from Employee emp "
                + " where emp.Emp_Name like ? and emp.Dept_Id = ? ";
        
         // Create a PreparedStatement object.
        PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
 
        // Set value for the first parameter (First '?')
        pstm.setString(1, "%S");
 
        // Set value for the second parameter (Second '?')
        pstm.setInt(2, 20);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            System.out.println(" ---- ");
            System.out.println("EmpId : " + rs.getInt("Emp_Id"));
            System.out.println("EmpNo : " + rs.getString(2));
            System.out.println("EmpName : " + rs.getString("Emp_Name"));
        }
         
        System.out.println();
        System.out.println("Set other parameters ..");
 
        // Reuse PreparedStatement
        // Set other values
        pstm.setString(1, "KI%");
        pstm.setInt(2,10);
         
        // Execute statement.
        rs = pstm.executeQuery();
         
        while (rs.next()) {
            System.out.println(" ---- ");
            System.out.println("EmpId : " + rs.getInt("Emp_Id"));
            System.out.println("EmpNo : " + rs.getString(2));
            System.out.println("EmpName : " + rs.getString("Emp_Name"));
        }
    
    }
}
