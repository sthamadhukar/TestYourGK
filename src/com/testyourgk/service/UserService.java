package com.testyourgk.service;

import com.testyourgk.model.user.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

/**
 * Created by Madhukar on 5/22/2016.
 */
public class UserService {


    private SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
    private Session session = sf.openSession();

    /* Method to CREATE an question in the database */
    public boolean save(Users user) {
        Transaction tx = null;
        Integer userId = null;
        try {
            tx = session.beginTransaction();
            userId = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        if(userId!=null){
            return true;
        }
        return false;
    }

    /* Method to  READ all the Users */
    List<Users> listUsers( ) {
        Session session = sf.openSession();
        Transaction tx = null;
        List users = null;
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM Users").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

}
