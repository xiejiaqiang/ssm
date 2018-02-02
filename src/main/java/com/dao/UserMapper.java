package com.dao;

import com.entity.po.Example.UserExample;
import com.base.dao.BaseMapper;
import com.entity.po.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectUserAndRoleByExample(UserExample example);

}