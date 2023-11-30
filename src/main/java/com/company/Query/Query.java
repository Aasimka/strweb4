package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM Authors ORDER BY firstName";
            System.out.println("Authors ordering by firstName:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);

            }
            String exampleQuery2 = "SELECT * FROM Authors ORDER BY lastName";
            System.out.println("Authors ordering by lastName:");
            ResultSet rs2 = stmt.executeQuery(exampleQuery2);
            while (rs2.next()) {
                int id = rs2.getInt("authorID");
                String firstName = rs2.getString("firstName");
                String lastName = rs2.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block, used to close resources
            JDBC.close();
        }
    }
}
