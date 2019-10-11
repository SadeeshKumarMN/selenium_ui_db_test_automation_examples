package utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.sql.*;

public class JDBCDriver {

    private Connection connectionWithPostgreS;


    /**
     * Create a Connection with PostgreSQL
     * Create a Statement for executeQuery
     * Execute Statement
     * Close the Connection
     */
    protected Multimap<String, String> createPostgresqlConnection(String sql) {
        Multimap<String, String> multiMap = ArrayListMultimap.create();
        try {
            Connection postgresConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "Nilani@12");
            Statement statement = postgresConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String person_new_id = resultSet.getString("id");
                String person_new_first_name = resultSet.getString("first_name");
                String person_new_last_name = resultSet.getString("last_name");
                String person_new_email = resultSet.getString("email");
                multiMap.put("id", person_new_id);
                multiMap.put("first_name", person_new_first_name);
                multiMap.put("last_name", person_new_last_name);
                multiMap.put("email", person_new_email);
            }
            postgresConnection.close();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("No results were returned by the query: " + sql);
        }
        return multiMap;
    }

}



