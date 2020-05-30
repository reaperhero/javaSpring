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



## 参数类型

- 传递简单类型


- 创建实体类对象

Mybatis使用OGNL表达式，自动解析对象字段的值，${}或者${}括号中的值为实体类对象属性名字

- pojo 包装类进行查询

Object Graphic Navigation Language ，即对象图导航语言。它是通过对象的取值方法来获取数据。在写法上把get给省略了。
使用场景：在开发中如果想实现复杂查询 ，查询条件不仅包括用户查询条件，还包括其它的查询条件（比如将用户购买商品信息也作为查询条件），这时可以使用 pojo 包装对象传递输入参数



## 数据源

UNPOOLED ： 不使用连接池的数据源。采用传统的 javax.sql.DataSource 规范中的连接池，Mybatis 中有针对规范的实现

POOLED ： 使用连接池的数据源。采用池的思想

JNDI ： 使用 JNDI 实现的数据源，采用服务器提供的 JNDI 技术实现，来获取 DataSource 对象，不同的服务器所能拿到的 DataSource 是不一样的。JNDI在Junit单元测试是无法使用的，只能在jsp页面中调用


## 动态SQL

- if标签

```
<select id="findUserByCondition" resultMap="User" parameterType="User">
    select * from user
    <where>
        <if test="userName != null">
            and username = #{userName}
        </if>
        <if test="userSex != null">
            and sex = #{userSex}
        </if>
    </where>
</select>
```

- foreach

```
<select id="findUserInIds" resultMap="User" parameterType="User">
    select * from user
    <where>
        <if test="ids != null and ids.size()>0">
            <foreach collection="ids" open="and id in (" close=")" item="uid" separator=",">
                #{uid}
            </foreach>
        </if>
    </where>
</select>
```

## 表关联

- 1对多

场景：用户与账户

- 多对多

场景：用户与角色

中间表做关联



## Mybatis加载

- 立即加载

只要调用方法，就会立马发起查询

- 延迟加载

在真正使用数据的时候才发起查询，不用的时候不查询，按需加载（懒加载）