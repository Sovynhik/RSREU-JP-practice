package ru.rsreu.sovynhik.utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseCleaner {

    public static void clearAllTables() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.createMutationQuery("DELETE FROM Auto").executeUpdate();
            session.createMutationQuery("DELETE FROM User").executeUpdate();

            transaction.commit();
            System.out.println("Таблицы успешно очищены.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
