package com.testyourgk.service;

import com.testyourgk.model.questions.Questions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.Query;

import java.util.Collections;
import java.util.List;

/**
 * Created by Madhukar on 5/21/2016.
 */
public class QuestionService {
    private SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
    private Session session = sf.openSession();

    /* Method to CREATE an question in the database */
    public boolean save(Questions questions) {
        Transaction tx = null;
        Integer questionId = null;
        try {
            tx = session.beginTransaction();
            questionId = (Integer) session.save(questions);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        if(questionId!=null){
            return true;
        }
        return false;
    }

    /* Method to  READ all the questions */
    public List<Questions> listQuestions() {
        Session session = sf.openSession();
        Transaction tx = null;
        List questions = null;
        try {
            tx = session.beginTransaction();
            questions = session.createQuery("FROM Questions").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return questions;
    }

    /* Method to  READ particular questions  on basis of id*/
    public Questions listQuestions(int questionId) {
        Session session = sf.openSession();
        Transaction tx = null;
        Questions question = null;
        try {
            tx = session.beginTransaction();
            question =  (Questions)session.get(Questions.class, questionId);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return question;
    }

    /* Method to DELETE an question from the records */
    public void deleteQuestion(Integer questionId){
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Questions question =  (Questions)session.get(Questions.class, questionId);
            session.delete(question);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to UPDATE question*/
    public void updateQuestion(Questions updatedQuestion ){
        Session session = sf.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            session.update(updatedQuestion);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    //max id find
    public int maxId() {
        Session session = sf.openSession();
        Transaction tx = null;
        List maxId = null;
        try {
            tx = session.beginTransaction();
            maxId = session.createQuery("SELECT max(id) FROM Questions").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Integer)maxId.get(0);
    }    //max id find
    public int minId() {
        Session session = sf.openSession();
        Transaction tx = null;
        List minId = null;
        try {
            tx = session.beginTransaction();
            minId = session.createQuery("SELECT min(id) FROM Questions").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Integer)minId.get(0);
    }

}


