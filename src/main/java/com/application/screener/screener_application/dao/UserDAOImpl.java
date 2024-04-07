package com.application.screener.screener_application.dao;

import com.application.screener.screener_application.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Session currentSession = entityManager.unwrap(Session.class);
        TypedQuery<User> query = currentSession.createQuery("select u from User u left join fetch u.shows sh", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        User user = null;
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.user_id = :userId", User.class);
        query.setParameter("userId", id);
        user = query.getSingleResult();
        return user;
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user){
        entityManager.merge(user);
        return user;
    }

    @Override
    public Long deleteUser(Long id) {
        Query query = entityManager.createQuery("delete from User u where u.user_id = :userId");
        query.setParameter("userId",id);
        int deletedCount = query.executeUpdate();
        if(deletedCount==0) {
            throw new NoSuchElementException();
        }
        return id;
    }
}
