package cn.chenqiangjun.dao;

import cn.chenqiangjun.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {


    @Select("SELECT * FROM user")
    List<User> findAll();
}

