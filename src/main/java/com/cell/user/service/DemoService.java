package com.cell.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cell.user.entiy.User;
import com.cell.user.mapper.UserMapper;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class DemoService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        return user;
    }

}
