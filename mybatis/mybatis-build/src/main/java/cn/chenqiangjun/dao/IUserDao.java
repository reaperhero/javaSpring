package cn.chenqiangjun.dao;

import cn.chenqiangjun.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}

