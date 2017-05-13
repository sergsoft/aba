package ru.sergsw.aba.openshift.repositories;

import ru.sergsw.aba.openshift.security.UserInfo;

public interface AuthRepository {
    UserInfo findByLogin(String login);
}
