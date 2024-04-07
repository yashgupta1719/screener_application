package com.application.screener.screener_application.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long user_id;
    @Column
    private String user_name;
    @Column
    private String user_email;
    @Column
    private Long user_phone_number;

    public User(){}

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_show",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private Set<Show> shows;

    public User(Long user_id, String user_name, String user_email, Long user_phone_number) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone_number = user_phone_number;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_phone_number(Long user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public Set<Show> getShows() {
        return shows;
    }

    public void setShows(Set<Show> shows) {
        this.shows = shows;
    }

    public String getUser_email() {
        return user_email;
    }

    public Long getUser_phone_number() {
        return user_phone_number;
    }
}
