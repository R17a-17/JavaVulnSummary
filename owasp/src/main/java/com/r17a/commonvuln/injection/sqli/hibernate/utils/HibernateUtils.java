package com.r17a.commonvuln.injection.sqli.hibernate.utils;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.r17a.commonvuln.injection.sqli.hibernate.pojo.User;


public class HibernateUtils {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    static{
        try{
            Configuration configuration = new Configuration().configure();

            configuration.addClass(User.class);

            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }
    //返回会话工厂对象
    public static SessionFactory getSessionFactory(){
        return factory;
    }
    //返回一个会话对象
    public static Session getSession(){
        Session session = null;
        if(factory!=null) {
            session = factory.openSession();
        }
        return session;
    }
    //关闭指定的会话对象
    public static void closeSession(Session session){
        if(session!=null){
            if(session.isOpen()) {
                session.close();
            }
        }
    }
}
