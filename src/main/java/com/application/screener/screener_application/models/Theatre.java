package com.application.screener.screener_application.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_theatre")
public class Theatre {

    public Theatre(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "th_id")
    private Long theatre_id;
    @Column(name = "th_name")
    private String theatre_name;


    public Long getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(Long theatre_id) {
        this.theatre_id = theatre_id;
    }

    public String getTheatre_name() {
        return theatre_name;
    }

    public void setTheatre_name(String theatre_name) {
        this.theatre_name = theatre_name;
    }
}
