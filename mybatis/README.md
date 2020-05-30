# Mybatis

## 环境搭建

环境依赖
- 创建mave工程，导入坐标
- 创建实体类对象和dao的接口
- 创建Mybatis的主配置文件SqlMapConfig.xml
- 创建映射配置文件，关联Mapper.xml和对象接口

执行流程
- 读取配置文件
- 创建SqlSessionFactory工厂
- 创建SqlSession
- 创建Dao接口的代理方法
- 执行Dao中的方法，关闭资源

