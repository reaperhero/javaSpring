import cn.chenqiangjun.dao.IUserDao;
import cn.chenqiangjun.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws Exception {
        try {
            // 1. 读取配置文件
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 2. 创建 SqlSessionFactory 工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            // 3. 获取 SqlSession 对象
            SqlSession sqlSession = factory.openSession();
            // 4. 使用 SqlSession 创建 Mapper 的代理对象
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            // 5. 使用代理对象执行查询
            List<User> users = iUserDao.findAll();
            for (User user:users){
                System.out.println(user);
            }
            // 6. 释放资源
            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
