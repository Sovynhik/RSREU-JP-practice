package ru.rsreu.sovynhik.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.rsreu.sovynhik.models.Auto;
import ru.rsreu.sovynhik.models.User;
import ru.rsreu.sovynhik.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDao {

    public User findById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "SELECT u FROM User u LEFT JOIN FETCH u.autos WHERE u.id = :id", User.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    public void save(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }
    }

    public void update(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        }
    }

    public void delete(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(user);
            tx.commit();
        }
    }

    public Auto findAutoById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.find(Auto.class, id);
        }
    }

    public List<User> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User u LEFT JOIN FETCH u.autos", User.class)
                    .getResultList();
        }
    }
}