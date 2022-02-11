package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class MySQLUsersDao implements Users{
//cpied from the MySQLadsDao so there is no difference between daos
    private Connection connection = null;

    public MySQLUsersDao(Config config) {

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String searchQuery= "SELECT * FROM users WHERE username = ?";
        User user = new User();
        try {

        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }

    }catch (SQLException e){
            e.printStackTrace();
        } return null;
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        long id = 0; // this is done so it return something even if is empty.
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting user.", e);
        }
    }
}