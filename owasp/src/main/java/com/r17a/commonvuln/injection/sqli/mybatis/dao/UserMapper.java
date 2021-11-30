package com.r17a.commonvuln.injection.sqli.mybatis.dao;

import com.r17a.commonvuln.injection.sqli.mybatis.pojo.User;

public interface UserMapper {
    User getById(String id);

    User getByIdPrepare(String id);
}
