package uz.epam.webproject.service;

public interface UserService {

    boolean authenticate(String firstName, String email);
}
