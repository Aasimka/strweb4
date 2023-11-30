package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query1 {
    public static void main(String[] argv) {
        updateTables();
    }
    public static void updateTables() {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updatePublishersTable(stmt);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }
    private static void updatePublishersTable(Statement stmt) {
        String publishers[] = { "ForVideo" };
        // reset the auto increment
        String updatePublishersTable = "ALTER TABLE Publishers AUTO_INCREMENT = 1";
        try {
            stmt.executeUpdate(updatePublishersTable);
        } catch (SQLException e) {
            System.out.println("Execute Update Failed!");
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < publishers.length; i++) {
            updatePublishersTable = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + publishers[i] + "')";
            try {
                stmt.executeUpdate(updatePublishersTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

}
