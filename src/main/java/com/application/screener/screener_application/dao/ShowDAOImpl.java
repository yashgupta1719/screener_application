package com.application.screener.screener_application.dao;

import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowDAOImpl implements ShowDAO{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Show> getAllShows() {
        TypedQuery<Show> query = entityManager.createQuery("select sh from Show sh", Show.class);
        return query.getResultList();
    }

    @Override
    public List<Show> getUserShows(User Id) {
        return null;
    }

    @Override
    public Show createShow(Show show) {
        Show createdShow = null;
        if(show.getShowId()!=null) {
            createdShow = entityManager.find(Show.class, show.getShowId());
            if(createdShow.getUserId()==show.getUserId())
                return createdShow;
        }
        if(createdShow!=null){
            entityManager.merge(show);
        }
        else{
            entityManager.persist(show);
        }
        return show;
    }

    @Override
    public Show updateShow(Show show) {
        return null;
    }

    @Override
    public Long deleteShow(Long showId) {
        return null;
    }
}
