package com.sbrown52;

import java.sql.*;

public class ImpalaTestKrb {
    // JDBC DRIVER classname
    public static final String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    // String of impala connection
    public static final String CONNETION_URL = "jdbc:impala://quickstart.cloudera:21050;SocketTimeout=0;AuthMech=1;AuthType=1;KrbRealm=CLOUDERA;KrbHostFQDN=quickstart.cloudera;KrbServiceName=impala;";

    public static void main(String[] args) throws ClassNotFoundException {
        // Set some system properties - we need these!
        System.setProperty("sun.security.krb5.debug","true"); // you might want to turn this off when it's working
        System.setProperty("java.security.krb5.kdc", "quickstart.cloudera");
        System.setProperty("java.security.krb5.realm","CLOUDERA");
        System.setProperty("java.security.auth.login.config","jaas.conf");

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
