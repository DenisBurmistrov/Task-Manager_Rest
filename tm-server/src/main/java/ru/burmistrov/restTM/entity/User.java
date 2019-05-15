package ru.burmistrov.restTM.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.restTM.entity.enumerated.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "app_user")
public class User implements Serializable {

    @NotNull
    @Id
    private String id = UUID.randomUUID().toString();

    @Nullable
    @Column(name = "firstName")
    private String firstName;

    @Nullable
    @Column(name = "middleName")
    private String middleName;

    @Nullable
    @Column(name = "lastName")
    private String lastName;

    @Nullable
    @Column(name = "login")
    private String login;

    @Nullable
    @Column(name = "passwordHash")
    private String password;

    @Nullable
    @Column(name = "email")
    private String email;

    @Nullable
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public User() {
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
