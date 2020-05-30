package cn.chenqiangjun.dao;

import cn.chenqiangjun.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 添加用户
     * @param user
     * @return 成功返回1，失败返回0
     */
    int saveUser(User user);





}

