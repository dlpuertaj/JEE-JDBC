/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dlpuertaj
 */
public class QueryData {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        
        //Get connection
        Connection connection = ConnectionUtils.getMyConnection();
        
        //Create statement
        Statement statement = connection.createStatement();
        
        String sql = "SELECT Emp_Id,Emp_No,Emp_Name FROM Employee";
        
        //Execute sql quary
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next()){
            int empId = rs.getInt(1);
            String empNo = rs.getString(2);
            String empName = rs.getString("Emp_Name");
            System.out.println("----------------------------");
            System.out.println("EmpId: "+empId);
            System.out.println("EmpNo: "+empNo);
            System.out.println("EmpName: "+empName);
        }   
        
        //Close connection
        connection.close();
    }
}
