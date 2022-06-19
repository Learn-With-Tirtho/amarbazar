package com.rktirtho.amarbazar.repository;

import com.rktirtho.amarbazar.configuration.DatabaseConfig;
import com.rktirtho.amarbazar.model.UserRegistrationRequest;
import com.rktirtho.amarbazar.model.UserResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phone_pumber";
    private static final String REGISTRATION_TIME = "created_at";
    private static final String PASSWORD = "password";

    public int saveUser(UserRegistrationRequest request){
        DatabaseConfig databaseConfig = new DatabaseConfig();
        Connection connection = databaseConfig.connect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
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
        PreparedStatement statement = null;
        boolean isUserExist = false;
        try {
            statement = connection.prepareStatement(
                    "SELECT email from user_table where email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            isUserExist = resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isUserExist;
    }

    public List<UserResponse> getAllUser() {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        Connection connection = databaseConfig.connect();
        PreparedStatement statement = null;
        boolean isUserExist = false;
        List<UserResponse> responseList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(
                    "SELECT * from user_table");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                UserResponse response = new UserResponse();
                response.setName(resultSet.getString(NAME));
                response.setEmail(resultSet.getString(EMAIL));
                response.setPhoneNumber(resultSet.getString(PHONE_NUMBER));
                response.setRegistrationDate(resultSet.getDate(REGISTRATION_TIME));
                responseList.add(response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return responseList;
    }

    public boolean findUserByCredential(String email, String password) {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        Connection connection = databaseConfig.connect();
        PreparedStatement statement = null;
        boolean isUserExist = false;
        try {
            statement = connection.prepareStatement(
                    "SELECT email from user_table where email=? and password=?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            isUserExist = resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isUserExist;
    }

}
