import cn.chenqiangjun.dao.IAccountDao;
import cn.chenqiangjun.dao.IUserDao;
import cn.chenqiangjun.domain.Account;
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
    private IAccountDao iAccountDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
        iAccountDao = session.getMapper(IAccountDao.class);
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


    /*
    * 查询Account的同时，立即查询出所属的用户信息
    *
    * */
    @Test
    public void testFindAllAccountWithUid(){
        List<Account> accounts = iAccountDao.findAll();
        for(Account account : accounts){
            System.out.println("----每个账户的信息-----");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    /*
     * 查询Account的同时，延迟查询出所属的用户信息
     *
     * */
    @Test
    public void testFindAllUserWithAid(){
        List<User> users = userDao.findAllWithAccount();
        for(User user : users){
            System.out.println("----每个账户的信息-----");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }
}
