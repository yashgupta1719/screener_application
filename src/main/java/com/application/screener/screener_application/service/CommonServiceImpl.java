package com.application.screener.screener_application.service;

import com.application.screener.screener_application.dao.NotificationDAO;
import com.application.screener.screener_application.dao.ShowDAO;
import com.application.screener.screener_application.dao.UserDAO;
import com.application.screener.screener_application.models.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.SqsMessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ShowDAO showDAO;

    @Autowired
    private NotificationDAO notificationDAO;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${aws.queueName}")
    private String queueName;

    @Transactional
    public Show createShow(Show showObj) {
        Show show = showDAO.createShow(showObj);
        Long userId = showObj.getUserId();
        User user = userDAO.getUser(userId);
        user.getShows().add(showObj);
        userDAO.update(user);

        Long notification_obj_id = notificationDAO.getNextIDValueFromSEQUENCE();
        NotificationObject notificationObject = new NotificationObject();
        notificationObject.setId(notification_obj_id);
        notificationObject.setEntity_type_id(1);
        notificationObject.setEntity_id(show.getShowId());
        notificationObject.setDate(show.getShowDate());
        notificationObject.setTime(show.getShowTime());

//        NotificationSender notificationSender = new NotificationSender();
//        notificationSender.setNotification_object_id(notificationObject.getId());
//        notificationSender.setActor_id(show.getUserId());
//
//        List<User> users = userDAO.getAllUsers();
//        List<NotificationReceiver> listNotificationReceiver = new ArrayList<>();
//        for(User u: users){
//            if(user.getUser_id()!=u.getUser_id()){
//                NotificationReceiver notificationReceiver = new NotificationReceiver();
//                notificationReceiver.setNotification_object_id(notificationObject.getId());
//                notificationReceiver.setReceiver_id(u.getUser_id());
//                listNotificationReceiver.add(notificationReceiver);
//            }
//        }

        MessagePayload Payload = new MessagePayload.Builder()
                .notificationObject(notificationObject)
                .build();

        Map<String, Object> headers = new HashMap<>();
        headers.put(SqsMessageHeaders.SQS_GROUP_ID_HEADER, "1");
        headers.put(SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER, "2");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String JSONObj = "";
        try{
            JSONObj = objectMapper.writeValueAsString(Payload);
        }
        catch(JsonProcessingException jsonProcessingException){
            System.out.println(jsonProcessingException.getMessage());
        }

        queueMessagingTemplate.send(queueName, MessageBuilder.withPayload(JSONObj).copyHeaders(headers).build());
        return show;
    }

    @Transactional
    public Long subscribeShow(Subscriber info){
        Show show = showDAO.getShow(info.getShowId());
        User user = userDAO.getUser(info.getUser_id());
        user.getShows().add(show);
        userDAO.update(user);
        return user.getUser_id();
    }

    @Transactional
    public Long unsubscribeShow(Subscriber info){
        Show show = showDAO.getShow(info.getShowId());
        User user = userDAO.getUser(info.getUser_id());
        user.getShows().remove(show);
        userDAO.update(user);
        return user.getUser_id();
    }

}
