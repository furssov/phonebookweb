package com.example.springweb.dao;

import com.example.springweb.models.Contact;
import com.mysql.jdbc.Driver;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContactDao {

   private static String URL="jdbc:mysql://localhost:3306/people?autoReconnect=true&useSSL=false";
   private static String USER="root";
   private static String PASSWORD="passwordWOW12!!@@";

   private static Connection connection;

   static
    {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Contact> showList() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM phonebook");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Contact contact = new Contact();
            contact.setId(resultSet.getInt("id"));
            contact.setName(resultSet.getString("name"));
            contact.setNumber(resultSet.getInt("number"));
            contacts.add(contact);
        }
       return contacts;
    }

    public Contact getByIndex(int index) throws SQLException {
        Contact contact = new Contact();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM phonebook WHERE id=?");
        preparedStatement.setInt(1, index);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        contact.setId(resultSet.getInt("id"));
        contact.setName(resultSet.getString("name"));
        contact.setNumber(resultSet.getInt("number"));
        return contact;
    }

    public void save(Contact contact) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO phonebook (name, number) values (?, ?)");
        preparedStatement.setString(1, contact.getName());
        preparedStatement.setString(2, String.valueOf(contact.getNumber()));
        preparedStatement.executeUpdate();
    }

    public void update(int id, Contact contact) throws SQLException {
          PreparedStatement preparedStatement = connection.prepareStatement("UPDATE phonebook SET name=?, number=? where id=?");
          preparedStatement.setString(1, contact.getName());
          preparedStatement.setInt(2, contact.getNumber());
          preparedStatement.setInt(3, contact.getId());
          preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM phonebook WHERE id=?");
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    }
}
