package com.application.screener.screener_application.models;

import java.util.List;

public class MessagePayload {

    private NotificationObject notificationObject;
    private List<NotificationReceiver> notificationReceiverList;
    private NotificationSender notificationSender;

    public MessagePayload(NotificationObject notificationObject, NotificationSender notificationSender, List<NotificationReceiver> notificationReceiverList){
        this.notificationObject = notificationObject;
        this.notificationReceiverList = notificationReceiverList;
        this.notificationSender = notificationSender;
    }

    public static class Builder {
        private NotificationObject notificationObject;
        private List<NotificationReceiver> notificationReceiverList;
        private NotificationSender notificationSender;

        public Builder notificationObject(NotificationObject notificationObject){
            this.notificationObject = notificationObject;
            return this;
        }

        public Builder notificationReceiverList(List<NotificationReceiver> notificationReceiverList){
            this.notificationReceiverList = notificationReceiverList;
            return this;
        }

        public Builder notificationSender(NotificationSender notificationSender){
            this.notificationSender = notificationSender;
            return this;
        }

        public MessagePayload build(){
            return new MessagePayload(notificationObject,notificationSender,notificationReceiverList);
        }

    }


}
