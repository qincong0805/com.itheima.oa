package com.itheima.oa.dao;

import java.util.Collection;

import com.itheima.oa.dao.base.BaseDao;
import com.itheima.oa.domain.User;

public interface UserDao extends BaseDao<User> {
      public Collection<User> getAllUser();
}
