import cn.chenqiangjun.dao.IUserDao;
import cn.chenqiangjun.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMybatis {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users =  userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser(){
        User user = new User("打敖",new Date(),"男","北京");
        userDao.saveUser(user);
    }


    @Test
    public void testUpdateUser(){
        User user = new User(56,"打敖",new Date(),"男","北京");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUserByID(){
        userDao.deleteUser(56);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(57);
        System.out.println(user);
    }


    @Test
    public  void testFindByName(){
        //List<User> users = userDao.findUserByName("%mybatis%");
        List<User> users = userDao.findUserByName("王");
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public  void testFindTotal(){
        int total = userDao.findTotalUser();
        System.out.println(total);
    }

    @Test
    public void testFindAllWithResultMap(){
        List<User> users = userDao.findAllWithResultMap();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindAllWithResultMapById(){
        User user = userDao.findByIdWithResultMap(57);
        System.out.println(user);
    }

}
