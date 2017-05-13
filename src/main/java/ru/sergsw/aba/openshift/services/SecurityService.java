package ru.sergsw.aba.openshift.services;

import ru.sergsw.aba.openshift.security.UserInfo;

public interface SecurityService {
    String makePassword(UserInfo userInfo, String password);

    String makeToken();

    String makeSalt();
}
