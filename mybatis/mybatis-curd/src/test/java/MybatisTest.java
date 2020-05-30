import cn.chenqiangjun.dao.IUserDao;
import cn.chenqiangjun.dao.IUserDaoMap;
import cn.chenqiangjun.domain.QueryVo;
import cn.chenqiangjun.domain.User;
import cn.chenqiangjun.domain.UserMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    /**
     * 测试之前执行，用于初始化
     */
    @Before
    public void init() throws Exception {
        // 1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 获取SqlSession对象
        sqlSession = factory.openSession();
    }


    /**
     * 测试结束执行，用于提交事务和释放资源
     */
    @After
    public void destroy() throws Exception {
        // 6. 提交事务
        sqlSession.commit();
        // 7. 释放资源
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindAll() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        // 5. 使用代理对象执行查询
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 测试添加用户
     */
    @Test
    public void saveUser() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("鱼开饭");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广东");

        // 调用dao完成添加
        System.out.println("保存前user："+user);
        int count = iUserDao.saveUser(user);
        System.out.println("保存后user："+user);
        System.out.println("添加条数为 : " + count);
    }


    /**
     * 测试更新用户
     */
    @Test
    public void updateUser() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(49);
        user.setUsername("大北京");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广东");

        // 调用dao完成添加
        iUserDao.updateUser(user);
    }


    /**
     * 测试删除用户
     */
    @Test
    public void deleteUser() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        iUserDao.removeUserById(48);
    }

    /**
     * 测试查询单个用户
     */
    @Test
    public void testGetUserById() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        // 确保id存在，否则返回null
        User user = iUserDao.getUserById(49);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testListUsersByName() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        //List<User> users = iUserDao.listUsersByName("%王%");
        List<User> users = iUserDao.listUsersByName("王");
        // 使用 Stream 流 + 方法引用，需要至少jdk8
        users.forEach(System.out::println);
    }

    /**
     * 测试查询用户总数
     */
    @Test
    public void testCountUser() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        int count = iUserDao.countUser();
        System.out.println("用户总记录数为 ： " + count);
    }


    /**
     * 测试根据Vo查询
     */
    @Test
    public void testListUsersByVo(){
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("王");
        vo.setUser(user);

        List<User> users = iUserDao.listUsersByVo(vo);
        users.forEach(System.out::println);
    }


    @Test
    public void testFindAllMap() {
        // 4. 使用 SqlSession 创建 Mapper 的代理对象
        IUserDaoMap iUserDaoMap = sqlSession.getMapper(IUserDaoMap.class);
        // 5. 使用代理对象执行查询
        List<UserMap> userMaps = iUserDaoMap.findAllMap();
        for (UserMap user : userMaps) {
            System.out.println(user);
        }
    }

}
