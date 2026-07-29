package com.rays.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/rays", "root", "root");

        Statement stmt = conn.createStatement();

        int i = stmt.executeUpdate(
                "INSERT INTO college VALUES " +
                "(6, 'SVVV', 'Indore', 'RGPV', 894), " +
                "(2, 'IIT Indore', 'Indore', 'IIT', 895), " +
                "(3, 'Medicaps University', 'Indore', 'Medicaps', 896), " +
                "(4, 'IPS Academy', 'Indore', 'DAVV', 897), " +
                "(5, 'LNCT', 'Bhopal', 'RGPV', 898)");

        System.out.println("Record inserted " + i + " rows affected");

        stmt.close();
        conn.close();
    }
}
