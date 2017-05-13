package ru.sergsw.aba.openshift.repositories;

import ru.sergsw.aba.openshift.domain.UserInfoImpl;
import ru.sergsw.aba.openshift.security.UserInfo;
import ru.sergsw.aba.openshift.services.SecurityService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.Collections.singleton;
import static ru.sergsw.aba.openshift.security.Role.ROLE_USER;

@Singleton
public class AuthRepositoryImpl implements AuthRepository {
    private final ConcurrentMap<String, UserInfo> users = new ConcurrentHashMap<>();

    @Inject
    private SecurityService securityService;

    public AuthRepositoryImpl() {
        addUser("user1");
    }

    private UserInfo addUser(String login) {
        UserInfo userInfo = new UserInfoImpl(login, securityService.makeSalt(), login, singleton(ROLE_USER.name()));
        users.put(login, userInfo);
        return userInfo;
    }

    @Override
    public UserInfo findByLogin(String login) {
        return users.get(login);
    }
}
