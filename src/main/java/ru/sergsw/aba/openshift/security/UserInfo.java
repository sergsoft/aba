package ru.sergsw.aba.openshift.security;

public interface UserInfo {
    String getEncryptedPassword();

    byte[] getSalt();

    String getLogin();
}
