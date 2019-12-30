package com.uniyaz.dao;

import com.uniyaz.domain.User;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDao {

    public User login(String userName, String password){

        User user = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select user From User user Where user.userName =: userName and user.password =: password";
            Query query = session.createQuery(hql);
            query.setParameter("userName", userName);
            query.setParameter("password", password);
            user = (User) query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
