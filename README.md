# impala-jdbc-example

This project contains examples on how to create a quick and dirty java client to query Impala from JDBC. We show how to do it with no authentication and with kerberos. We do not explain how to setup Kerberos on the cluster.

This project uses the Cloudera Quickstart VM running in a Virtual Box VM, which you will need running. You will also need to install and put the ImpalaJDBC41 driver on the classpath. This can be downloaded from: https://www.cloudera.com/downloads/connectors/impala/jdbc/2-6-3.html

Tested with CDH quickstart 5.13 and Impala JDBC driver 2.6.3
