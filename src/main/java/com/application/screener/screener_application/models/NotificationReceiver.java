package com.application.screener.screener_application.models;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_receiver")
public class NotificationReceiver {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "notification_object_id")
    private Long notification_object_id;

    @Column(name = "receiver_id")
    private Long receiver_id;

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

    public Long getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Long receiver_id) {
        this.receiver_id = receiver_id;
    }
}
