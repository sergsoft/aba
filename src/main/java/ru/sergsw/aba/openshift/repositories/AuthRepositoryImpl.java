package ru.sergsw.aba.openshift.repositories;

import ru.sergsw.aba.openshift.security.UserInfo;

public class AuthRepositoryImpl implements AuthRepository {
    @Override
    public UserInfo findByLogin(String login) {
        return null;
    }
}
