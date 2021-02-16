package main.java.Utilities;

import java.sql.*;

public class DatabaseConfig {


    public void connection() throws SQLException {

        String host = "localhost";
        String port = "3303";  // get to know while installing
        //user --> user and password set while installing mysql
        //Connection has been established
       Connection conn =  DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/databaseName","root","password");
       //statement has been created for executing the sql queries
       Statement statement = conn.createStatement();
        //fetched the data via query executed
       ResultSet resultSet = statement.executeQuery("Write query here");

       String cell_value = resultSet.getString("column label");

    }


}
