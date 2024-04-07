package com.application.screener.screener_application.service;

import com.application.screener.screener_application.dao.ShowDAO;
import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ShowServiceImpl implements ShowService{


    @Autowired
    private ShowDAO showDAO;

    @Override
    @Transactional
    public List<Show> getAllShows() {
        return showDAO.getAllShows();
    }

    @Override
    @Transactional
    public Show updateShow(Show show) {
        return null;
    }

    @Override
    @Transactional
    public Long deleteShow(Long showId) {
        return null;
    }
}
