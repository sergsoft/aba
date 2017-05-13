package ru.sergsw.aba.openshift.security;

import java.util.Collection;

public interface UserInfo {
    String getEncryptedPassword();

    byte[] getSalt();

    String getLogin();

    Collection<String> getRoles();
}
