package models.member;

import jakarta.servlet.http.HttpServletRequest;

public class LoginService {
    private LoginValidator validator;
    private UsersDao usersDao;

    public LoginService(LoginValidator validator, UsersDao usersDao) {
        this.validator = validator;
        this.usersDao = usersDao;
    }

    public void login(HttpServletRequest request) {

    }
}
