package uz.epam.webproject.dao;

public interface UserDao {

    boolean authenticate(String firstName, String email);
}
