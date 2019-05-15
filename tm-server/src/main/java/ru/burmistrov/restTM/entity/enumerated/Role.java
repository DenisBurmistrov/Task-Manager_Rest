package ru.burmistrov.restTM.entity.enumerated;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMINISTRATOR,
    COMMON_USER;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
