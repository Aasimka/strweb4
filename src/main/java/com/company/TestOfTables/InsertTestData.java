package com.company.TestOfTables;

import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;
public class InsertTestData {

    public static void main(String[] argv) {
        updateTables();
    }

    public static void updateTables() {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updateAuthorsTable(stmt);
            updateAuthorIsbnTable(stmt);
            updatePublishersTable(stmt);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }

    private static void updateAuthorsTable(Statement stmt) {
        String authorFirstNames[] = { "Jane", "Dan", "Ralph Waldo", "F.Scott","John", "Ernest", "Walter", "Stephen", "Stieg",
                "George", "Joanne K.", "John", "John R. R.", "Kurt", "Andy" };
        String authorLastNames[] = { "Austen", "Brown", "Emerson", "Firtzgerald", "Grisham", "Hemingway", "Isaacson",
                "King", "Larsson", "Orwell", "Rowling", "Steinbeck", "Tolkien", "Vonnegut", "Weir" };
        // reset the auto increment
        String updateAuthorsTable = "ALTER TABLE Authors AUTO_INCREMENT = 1";
        try {
            stmt.executeUpdate(updateAuthorsTable);
        } catch (SQLException e) {
            System.out.println("Execute Update Failed!");
            e.printStackTrace();
            return;
        }
        for (int i = 1; i <= authorFirstNames.length; i++) {
            updateAuthorsTable = "INSERT INTO Authors (firstName, lastName)" + "VALUES ('" + authorFirstNames[i - 1]
                    + "', '" + authorLastNames[i - 1] + "');";
            try {
                stmt.executeUpdate(updateAuthorsTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

    private static void updateAuthorIsbnTable(Statement stmt) {
        String isbn[] = { "0141439519", "0307474278", "0142437629", "0743273565", "0345543240", "0684801223",
                "1501127625", "1501175466", "0307949486", "0451524935", "0439708180", "0142000687", "0547928227",
                "0385333849", "0553418026" };
        for (int i = 1; i <= isbn.length; i++) {
            String updateAuthorISBNTable = "INSERT INTO authorISBN (authorID, isbn)" + "VALUES (" + i + ", '"
                    + isbn[i - 1] + "')";
            try {
                stmt.executeUpdate(updateAuthorISBNTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }



    private static void updatePublishersTable(Statement stmt) {
        String publishers[] = { "Penguin", "Anchor", "Scribner", "Dell Books", "Simon & Schuster", "Vintage Crime",
                "Signet", "Scholastic", "Houghton Mifflin", "Dial Press", "Broadway" };
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
