package uz.epam.webproject.dao.impl;

import uz.epam.webproject.dao.BaseDao;
import uz.epam.webproject.dao.UserDao;
import uz.epam.webproject.entity.User;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    public static final String EMAIL_FROM_CUSTOMER_FIRST_NAME = "SELECT email FROM customer WHERE customer.first_name = ?";
    private static final UserDaoImpl instance = new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }


    @Override
    public boolean authenticate(String firstName, String email) {
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker";
        Properties prop = new Properties();
        prop.setProperty("user", "springstudent");
        prop.setProperty("password", "springstudent");

//            String sql = "SELECT email FROM customer WHERE first_name = '" + firstName + "'";
        try(Connection connection = DriverManager.getConnection(url, prop);
            /*Statement statement = connection.createStatement()*/
            PreparedStatement preparedStatement = connection.prepareStatement(EMAIL_FROM_CUSTOMER_FIRST_NAME)){
            preparedStatement.setString(1, firstName);
//            ResultSet resultSet = statement.executeQuery(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            String emailFromDb;
            if(resultSet.next()){
                emailFromDb = resultSet.getString(1);
//                emailFromDb = resultSet.getString(1);
                return emailFromDb.equals(email);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }
}
