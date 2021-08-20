package io.jzheaux.springsecurity.resolutions.domain;

import io.jzheaux.springsecurity.resolutions.domain.User;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "authorities")
public class UserAuthority {
    @Id
    private UUID id;

    @ManyToOne
	//@JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @Column
    private String authority;

    public UserAuthority(User user, String authority) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.authority = authority;
    }

    public UserAuthority() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
