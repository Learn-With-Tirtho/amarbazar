package com.rktirtho.amarbazar.repository;

import com.rktirtho.amarbazar.configuration.DatabaseConfig;
import com.rktirtho.amarbazar.model.UserRegistrationRequest;

import java.sql.*;

public class UserRepository {

    public int saveUser(UserRegistrationRequest request){
        DatabaseConfig databaseConfig = new DatabaseConfig();
        Connection connection = databaseConfig.connect();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO user_table(name, email, password, phone_pumber, created_at) " +
                            "value (?,?,?,?,?)");

            statement.setString(1, request.getName());
            statement.setString(2, request.getEmail());
            statement.setString(3, request.getPassword());
            statement.setString(4, request.getPhoneNumber());
            statement.setDate(5, new Date(new java.util.Date().getTime()));
            return statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public boolean getUserByEmail(String email) {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        Connection connection = databaseConfig.connect();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT email from user_table where email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }



}
