package com.r17a.commonvuln.injection.sqli.jdbc;

import java.sql.*;

/**
 * TODO 设置用户名密码和Mysql地址
 * */
public class JdbcSqli {
    public static void main(String[] args) throws Exception {
        JdbcSqli jdbcSqli = new JdbcSqli();
        jdbcSqli.selectPoc("1 and 1=2 union select * from user");
        jdbcSqli.selectFix("2' and 1=2 union select * from user where '1'='1");
    }

    public void selectPoc(String value) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/users?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
        final String username = "root";
        final String password = "1qazXSW@3edc";

        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //创建Statement，编写sql语句
        Statement statement = connection.createStatement();
        String sql = "select * from user where id=" + value;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getObject("id"));
            System.out.println("name:" + resultSet.getObject("name"));
            System.out.println("password:" + resultSet.getObject("password"));
            System.out.println("date:" + resultSet.getObject("date"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public void selectFix(String value) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/users?useUnicode=true&characterEncoding=UTF-8";
        final String username = "root";
        final String password = "1qazXSW@3edc";

        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //创建Statement，编写sql语句
        String sql = "select * from user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,value);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getObject("id"));
            System.out.println("name:" + resultSet.getObject("name"));
            System.out.println("password:" + resultSet.getObject("password"));
            System.out.println("date:" + resultSet.getObject("date"));
        }
        preparedStatement.close();
        connection.close();
    }
}
