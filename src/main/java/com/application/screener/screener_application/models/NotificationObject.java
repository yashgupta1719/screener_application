package com.application.screener.screener_application.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Time;

import java.sql.Date;

@Entity
@Table(name = "notification_object")
public class NotificationObject {

    @Id
    @GenericGenerator(
            name = "assigned-identity",
            strategy = "com.application.screener.screener_application.helpers.UseExistingOrGenerateIdGenerator"
    )
    @GeneratedValue(
            generator = "assigned-identity",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "entity_type_id")
    private Integer entity_type_id;

    @Column(name = "entity_id")
    private Long entity_id;

    public Integer getEntity_type_id() {
        return entity_type_id;
    }

    public void setEntity_type_id(Integer entity_type_id) {
        this.entity_type_id = entity_type_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Long entity_id) {
        this.entity_id = entity_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Column(name ="date")
    private Date date;

    @Column(name = "time")
    private Time time;

}
