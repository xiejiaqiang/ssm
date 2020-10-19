package com.test;

import com.entity.po.systemManage.User;
import com.github.pagehelper.PageInfo;
import com.service.systemManage.IUserService;
import com.test.init.BaseTest;
import com.test.init.TestMenuTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(TestMenuTree.class);
    @Autowired
    private IUserService userService;
    @Test
    public void queryList(){
        PageInfo<User> userList= null;
        try {
            userList = userService.findUserPage(new User(),5,1,"","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("===========数据查询成功！userList={}",userList);
    }
}
