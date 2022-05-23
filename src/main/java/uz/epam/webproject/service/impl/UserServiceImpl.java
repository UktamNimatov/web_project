package uz.epam.webproject.service.impl;

import uz.epam.webproject.dao.impl.UserDaoImpl;
import uz.epam.webproject.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String firstName, String email) {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        return userDao.authenticate(firstName, email);
    }
}
