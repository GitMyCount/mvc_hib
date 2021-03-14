package com.dao;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        Session session = (Session) entityManager.getDelegate();

        Query<User> query = session.createQuery("from User", User.class);
        List<User> allUsers = query.getResultList();

        return allUsers;
    }

    @Override
    public void save(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User show(int id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("delete from User " +
                "where id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

    @Override
    public void update(int id, User updatedUser) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(updatedUser);
    }
}
