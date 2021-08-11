package com.example.traveldemo.service;

import com.example.traveldemo.dao.UserDao;
import com.example.traveldemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Maozh
 * @Date: 2021 07 17
 */
@Service
@Transactional        //在需要对一个service方法添加事务时，加上这个注解，如果发生unchecked exception，就会发生rollback
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        userDao.save(user);
    }
}
