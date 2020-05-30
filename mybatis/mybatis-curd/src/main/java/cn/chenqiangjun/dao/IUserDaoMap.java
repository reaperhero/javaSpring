package cn.chenqiangjun.dao;

import cn.chenqiangjun.domain.UserMap;

import java.util.List;

public interface IUserDaoMap {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<UserMap> findAllMap();
}
