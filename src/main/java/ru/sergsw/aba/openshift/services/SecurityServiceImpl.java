package ru.sergsw.aba.openshift.services;

import ru.sergsw.aba.openshift.config.IntValue;
import ru.sergsw.aba.openshift.security.UserInfo;

import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import static org.apache.commons.codec.binary.Hex.encodeHexString;
import static ru.sergsw.aba.openshift.config.ConfigValue.SEC_SALT_SIZE;
import static ru.sergsw.aba.openshift.config.ConfigValue.SEC_TOKEN_SIZE;

public class SecurityServiceImpl implements SecurityService {
    @Inject @IntValue(SEC_TOKEN_SIZE)
    private int tokenSize;
    @Inject @IntValue(SEC_SALT_SIZE)
    private int saltSize;

    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public String makePassword(UserInfo userInfo, String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(userInfo.getSalt());
            messageDigest.update(userInfo.getLogin().getBytes());
            messageDigest.update(password.getBytes());
            return encodeHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String makeToken() {
        return getRndString(tokenSize);
    }

    @Override
    public String makeSalt() {
        return getRndString(saltSize);
    }

    private String getRndString(int size) {
        byte[] arr = new byte[size];
        secureRandom.nextBytes(arr);
        return Base64.getEncoder().encodeToString(arr);
    }
}
