package ru.sergsw.aba.openshift.domain;

import ru.sergsw.aba.openshift.security.UserInfo;

import java.util.Collection;

public class UserInfoImpl implements UserInfo {
    private final String login;
    private final String salt;
    private final String password;
    private final Collection<String> roles;

    public UserInfoImpl(String login, String salt, String password, Collection<String> roles) {
        this.login = login;
        this.salt = salt;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String getEncryptedPassword() {
        return password;
    }

    @Override
    public byte[] getSalt() {
        return salt.getBytes();
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public Collection<String> getRoles() {
        return roles;
    }
}
