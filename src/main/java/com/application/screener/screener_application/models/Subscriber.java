package com.application.screener.screener_application.models;

public class Subscriber {
    private Long user_id;
    private Long showId;

    public Subscriber(){
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
