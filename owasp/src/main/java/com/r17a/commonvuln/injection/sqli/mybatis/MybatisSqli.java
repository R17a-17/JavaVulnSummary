package com.r17a.commonvuln.injection.sqli.mybatis;

import com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper;
import com.r17a.commonvuln.injection.sqli.mybatis.pojo.User;
import com.r17a.commonvuln.injection.sqli.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MybatisSqli {

    public static void main(String[] args) {
        MybatisSqli mybatisSqli = new MybatisSqli();
        System.out.println("--------------------------------poc test--------------------------------");
        mybatisSqli.getById("1 and 1=2 union select Host,User,1,authentication_string from mysql.user limit 1");
        mybatisSqli.getByLike("wang%' and 1=2 union select Host,User,1,authentication_string from mysql.user where User like '%root");
        mybatisSqli.getByIn("0) and 1=2 union select Host,User,1,authentication_string from mysql.user where (1)=(1");
        mybatisSqli.getByOrder("IF((select user())='root@localhost',id,name)");
//        mybatisSqli.getByOrder("id and extractvalue(1,concat(0x7C,(select user()),0x7C))");
        System.out.println("--------------------------------fix test--------------------------------");
        mybatisSqli.getByIdPrepare("1' and 1=2 union select Host,User,1,authentication_string from mysql.user where User='root");
        mybatisSqli.getByLikePrepare("wang%' and 1=2 union select Host,User,1,authentication_string from mysql.user where User like '%root");
        mybatisSqli.getByInFix(new String[]{"1","2"});
        mybatisSqli.getByOrderFix("IF((select user())='root@localhost',id,name)");
    }


    public void getById(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getById(id);
//        User user = sqlSession.selectOne("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getById", id);
        System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        sqlSession.close();
    }

    public void getByIdPrepare(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user = sqlSession.selectOne("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getByIdPrepare", id);
        System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        sqlSession.close();
    }

    public void getByLike(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.selectList("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getByLike", name);
        for (User user : users) {
            System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        }

        sqlSession.close();
    }

    public void getByLikePrepare(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.selectList("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getByLikePrepare", name);
        for (User user : users) {
            System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        }

        sqlSession.close();
    }

    public void getByIn(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.selectList("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getByIn", id);
        for (User user : users) {
            System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        }

        sqlSession.close();
    }

    public void getByInFix(String[] array) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.selectList("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getByInFix", array);
        for (User user : users) {
            System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        }

        sqlSession.close();
    }

    public void getByOrder(String coln) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.selectList("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getByOrder", coln);
        for (User user : users) {
            System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        }
        sqlSession.close();
    }

    public void getByOrderFix(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.selectList("com.r17a.commonvuln.injection.sqli.mybatis.dao.UserMapper.getByOrderFix", id);
        for (User user : users) {
            System.out.println(user.getId() + "-" + user.getName() + "-" + user.getDate());
        }
        sqlSession.close();
    }
}
