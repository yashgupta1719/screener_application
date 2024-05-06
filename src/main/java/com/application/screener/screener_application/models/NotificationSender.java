package com.application.screener.screener_application.models;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_creator")
public class NotificationSender {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNotification_object_id() {
        return notification_object_id;
    }

    public void setNotification_object_id(Long notification_object_id) {
        this.notification_object_id = notification_object_id;
    }

    public Long getActor_id() {
        return actor_id;
    }

    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }

    @Column(name = "notification_object_id")
    private Long notification_object_id;

    @Column(name = "actor_id")
    private Long actor_id;



}
