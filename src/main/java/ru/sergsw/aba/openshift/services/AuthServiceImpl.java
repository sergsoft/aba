package ru.sergsw.aba.openshift.services;

import ru.sergsw.aba.openshift.repositories.AuthRepository;
import ru.sergsw.aba.openshift.security.UserInfo;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Singleton
public class AuthServiceImpl implements AuthService {
    private @Inject AuthRepository authRepository;
    private @Inject SecurityService securityService;
    private final ConcurrentMap<String, UserInfo> users = new ConcurrentHashMap<>();

    @Override
    public String login(String login, String password) throws LoginException {
        UserInfo userInfo = authRepository.findByLogin(login);
        if (userInfo == null) throw new AccountNotFoundException();
        if (Objects.equals(userInfo.getEncryptedPassword(), securityService.makePassword(userInfo, password))) {
            String token = securityService.makeToken();
            users.put(token, userInfo);
            return token;
        }
        throw new FailedLoginException();
    }


}
