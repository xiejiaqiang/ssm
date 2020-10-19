package com.dao.systemManage;

import com.entity.po.Example.systemManage.UserExample;
import com.base.dao.BaseMapper;
import com.entity.po.systemManage.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectUserAndRoleByExample(UserExample example);

}