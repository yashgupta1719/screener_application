package com.application.screener.screener_application.dao;

import com.application.screener.screener_application.models.Show;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLData;
import java.sql.SQLException;

@Repository
public class NotificationDAO {

    @Autowired
    private EntityManager entityManager;

    public Long getNextIDValueFromSEQUENCE(){
        Long nextID = null;
        Query query = entityManager.createNativeQuery("select next_val from screener_backend.notification_object_seq");
        nextID = (Long) query.getSingleResult();
        Query query2 =  entityManager.createNativeQuery("update screener_backend.notification_object_seq set next_val = ?");
        query2.setParameter(1,nextID+2);
        query2.executeUpdate();
        System.out.println("Next ID to use: "+nextID);
        return nextID + 1L;
    }

}
