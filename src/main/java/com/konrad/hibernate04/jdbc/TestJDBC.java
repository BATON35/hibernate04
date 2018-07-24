package com.konrad.hibernate04.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "aaaaaa84";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection succeed ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
