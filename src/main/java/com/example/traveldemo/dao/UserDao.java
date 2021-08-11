package com.example.traveldemo.dao;

import com.example.traveldemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Maozh
 * @Date: 2021 07 17
 */

@Mapper
public interface UserDao {

    void save(User user);

}
