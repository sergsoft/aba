package ru.sergsw.aba.openshift.config;

import javax.enterprise.inject.Produces;

import static ru.sergsw.aba.openshift.config.ConfigValue.SEC_SALT_SIZE;
import static ru.sergsw.aba.openshift.config.ConfigValue.SEC_TOKEN_SIZE;

public class SecurityConfig {

    @Produces
    @IntValue(SEC_TOKEN_SIZE)
    public int getTokenSize() {
        return 40;
    }

    @Produces
    @IntValue(SEC_SALT_SIZE)
    public int getSaltSize() {
        return 4;
    }
}
