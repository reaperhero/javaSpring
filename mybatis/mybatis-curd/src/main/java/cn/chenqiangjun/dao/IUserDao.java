package cn.chenqiangjun.dao;

import cn.chenqiangjun.domain.QueryVo;
import cn.chenqiangjun.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     * @return 成功返回1，失败返回0
     */
    int saveUser(User user);

    /**
     * 修改用户
     * @param user
     * @return 成功返回1，失败返回0
     */
    int updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param userId
     * @return 成功返回1，失败返回0
     */
    int removeUserById(Integer userId);

    /**
     * 根据id查询单个用户
     * @param userId
     * @return
     */
    User getUserById(Integer userId);


    /**
     * 根据姓名模糊查询多个用户
     *
     * @param username
     * @return
     */
    List<User> listUsersByName(String username);

    /**
     * 查询用户总数
     *
     * @return
     */
    int countUser();




    /**
     * 根据查询条件模糊查询用户
     *
     * @param vo
     * @return
     */
    List<User> listUsersByVo(QueryVo vo);

}

