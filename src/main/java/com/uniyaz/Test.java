package com.uniyaz;

import com.uniyaz.utils.HibernateUtil;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.openSession();
    }
}
