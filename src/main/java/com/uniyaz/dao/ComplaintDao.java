package com.uniyaz.dao;

import com.uniyaz.domain.Complaint;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ComplaintDao {

    public Complaint saveComplaint(Complaint complaint) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            complaint = (Complaint) session.merge(complaint);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return complaint;
    }

    public List<Complaint> findAllComplaints() {
        List<Complaint> complaintList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select complaint From Complaint complaint";
            Query query = session.createQuery(hql);
            complaintList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return complaintList;
    }

    public Complaint findAllComplaintsByName(String clientNameSurname) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select complaint From Complaint complaint Where complaint.clientNameSurname = :clientNameSurname";
            Query query = session.createQuery(hql);
            query.setParameter("clientNameSurname", clientNameSurname);
            return  (Complaint) query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }






}
