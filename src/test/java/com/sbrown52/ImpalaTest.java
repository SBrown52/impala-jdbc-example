package com.sbrown52;

/*
This is a basic quick and dirty class to connect to the Impala using Cloudera's Impala JDBC driver
We connect to the quickstart.cloudera VM which is running locally in VirtualBox.
We are using version 5.13
*/

import java.sql.*;

public class ImpalaTest {
    // JDBC DRIVER classname
    public static final String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    // String of impala connection
    public static final String CONNETION_URL = "jdbc:impala://quickstart.cloudera:21050";

    public static void main(String[] args) throws ClassNotFoundException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        // SQL query to run against Impala, using data loading in CDH tutorial
        String impalaQuery = "select * from products limit 10";
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(CONNETION_URL);

            stmt = con.createStatement();
            rs = stmt.executeQuery(impalaQuery);

            // Print out some results
            while (rs.next()) {
                System.out.printf(rs.getString(1) + ", ");
                System.out.printf(rs.getString(2)+ ", ");
                System.out.printf(rs.getString(2)+ ", ");
                System.out.printf(rs.getString(3)+ ", ");
                System.out.printf(rs.getString(4)+ ", ");
                System.out.printf(rs.getString(5)+ ", ");
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // should probably close connection
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
