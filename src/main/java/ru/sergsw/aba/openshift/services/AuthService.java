package ru.sergsw.aba.openshift.services;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.LoginException;

public interface AuthService {
    String login(String login, String password) throws LoginException;
}
