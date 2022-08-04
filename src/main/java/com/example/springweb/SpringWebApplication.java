package com.example.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

@SpringBootApplication
public class SpringWebApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringWebApplication.class, args);

        /*
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/people?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "passwordWOW12!!@@";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM phonebook";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") +
                        " " + resultSet.getInt("number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

    }

}
