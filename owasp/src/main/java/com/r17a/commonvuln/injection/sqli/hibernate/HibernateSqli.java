package com.r17a.commonvuln.injection.sqli.hibernate;

import com.r17a.commonvuln.injection.sqli.hibernate.utils.HibernateUtils;
import com.r17a.commonvuln.injection.sqli.hibernate.pojo.User;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateSqli {
    public static void main(String[] args) {
        HibernateSqli hibernateSqli = new HibernateSqli();
        hibernateSqli.getUserByName("lisi' and user()='root@localhost");
        hibernateSqli.getUserByNamePrepare("lisi");
    }

    public void getUserByName(String name){
        Session session = HibernateUtils.getSession();
        Query<User> query = session.createQuery("from User where name = '" + name + "'", User.class);
        User user = query.getSingleResult();
        System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        session.close();
    }

    public void getUserByNamePrepare(String name){
        Session session = HibernateUtils.getSession();
        Query<User> query = session.createQuery("from User where name = :name", User.class);
        query.setParameter("name",name);
        User user = query.getSingleResult();
        System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        session.close();
    }
}
