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

自定义Mybatis框架流程

![](https://img-blog.csdnimg.cn/20200127102223857.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2ExMDkyODgyNTgw,size_16,color_FFFFFF,t_70#pic_center)