package com.application.screener.screener_application.service;

import com.application.screener.screener_application.controller.showController;
import com.application.screener.screener_application.dao.ShowDAO;
import com.application.screener.screener_application.dao.UserDAO;
import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.Subscriber;
import com.application.screener.screener_application.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ShowDAO showDAO;
    @Transactional
    public Show createShow(Show showObj){
        Show show = showDAO.createShow(showObj);
        Long userId = showObj.getUserId();
        User user = userDAO.getUser(userId);
        user.getShows().add(showObj);
        userDAO.update(user);
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
