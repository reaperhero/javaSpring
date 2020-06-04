# Spring


## IOC

1. ApplicationContext的三个常用实现类
- ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--把对象的创建交给spring来管理-->
    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"></bean>

    <bean id="accountDao" class="com.itheima.dao.impl.AccountDaoImpl"></bean>
</beans>
```

- FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
- AnnotationConfigApplicationContext：读取注解创建容器的

2. 三种方式创建Bean

- 默认构造函数创建: 在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。
```<bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"></bean>```

- 普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）
```
<bean id="instanceFactory" class="com.itheima.factory.InstanceFactory"></bean>
<bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
```

- 静态方法创建对象: 使用某个类中的静态方法创建对象，并存入spring容器
```<bean id="accountService" class="com.itheima.factory.StaticFactory" factory-method="getAccountService"></bean>```


3. bean scope属性

```
singleton：单例的（默认值）
prototype：多例的
request：作用于web应用的请求范围
session：作用于web应用的会话范围
global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时，它就是session
```

4. bean生命周期

单例对象
    出生：当容器创建时对象出生
    活着：只要容器还在，对象一直活着
    死亡：容器销毁，对象消亡
    总结：单例对象的生命周期和容器相同
多例对象
    出生：当我们使用对象时spring框架为我们创建
    活着：对象只要是在使用过程中就一直活着。
    死亡：当对象长时间不用，且没有别的对象引用时，由Java的垃圾回收器回收

```
<bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
          scope="prototype" init-method="init" destroy-method="destroy"></bean>
```

## DI

- 依赖注入类型：1、基本类型和String 2、其他bean类型（在配置文件中或者注解配置过的bean） 3、复杂类型/集合类型

- 依赖注入的方式：

第一种：使用构造函数提供
标签属性
type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型
index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始
name：用于指定给构造函数中指定名称的参数赋值
value：用于提供基本类型和String类型的数据
ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象

优势：在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
弊端：改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供。

```
<bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl">
    <constructor-arg name="name" value="泰斯特"></constructor-arg>
    <constructor-arg name="age" value="18"></constructor-arg>
    <constructor-arg name="birthday" ref="now"></constructor-arg>
</bean>

<bean id="now" class="java.util.Date"></bean>
```
第二种：使用set方法提供 
标签属性
name：用于指定注入时所调用的set方法名称
value：用于提供基本类型和String类型的数据
ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象

```
<bean id="accountService2" class="com.itheima.service.impl.AccountServiceImpl2">
    <property name="name" value="TEST" ></property>
    <property name="age" value="21"></property>
    <property name="birthday" ref="now"></property>
</bean>
<bean id="now" class="java.util.Date"></bean>
```
复杂类型的注入/集合类型的注入
```
<bean id="accountService3" class="com.itheima.service.impl.AccountServiceImpl3">
    <property name="myStrs">
        <set>
            <value>AAA</value>
            <value>BBB</value>
            <value>CCC</value>
        </set>
    </property>

    <property name="myList">
        <array>
            <value>AAA</value>
            <value>BBB</value>
            <value>CCC</value>
        </array>
    </property>

    <property name="mySet">
        <list>
            <value>AAA</value>
            <value>BBB</value>
            <value>CCC</value>
        </list>
    </property>

    <property name="myMap">
        <props>
            <prop key="testC">ccc</prop>
            <prop key="testD">ddd</prop>
        </props>
    </property>

    <property name="myProps">
        <map>
            <entry key="testA" value="aaa"></entry>
            <entry key="testB">
                <value>BBB</value>
            </entry>
        </map>
    </property>
</bean>
```

第三种：使用注解提供

```
配置扫描包
<context:component-scan base-package="com.itheima"></context:component-scan>
```

- 注解分类

1、创建对象
Component与```<bean>```标签实现的功能是一样的，`value`：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写

2、注入数据

Autowired: 自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功,反之报错。Autowired可以出现在变量或方法上，类不需要有set方法。

Qualifier：类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以。value：用于指定注入bean的id。

Resource：直接按照bean的id注入。它可以独立使用。name：用于指定bean的id。

Value： 用于基本类型和String类型注入。value：用于指定数据的值。它可以使用spring中SpEL。集合类型的注入只能通过XML来实现

3、作用范围

Scope：用于指定bean的作用范围，value：指定范围的取值。常用取值：singleton prototype

4、生命周期

PostConstruct：用于指定初始化方法

PreDestroy：用于指定销毁方法

## 配置类

Configuration：指定当前类是一个配置类，当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。

ComponentScan：用于通过注解指定spring在创建容器时要扫描的包

Bean：用于把当前方法的返回值作为bean对象存入spring的ioc容器中，name:用于指定bean的id。当不写时，默认值是当前方法的名称。当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。 查找的方式和Autowired注解的作用是一样的

Import：用于导入其他的配置类，value：用于指定其他配置类的字节码。 当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类

PropertySource： 用于指定properties文件的位置。value：指定文件的名称和路径。


## AOP


在程序运行期间，不修改源码对已有方法进行增强。在需要执行的时候，使用动态代理的技术，在不修改源码的基础上，对我们的已有方法进行增强。

动态代理：字节码随用随创建，随用随加载。它与静态代理的区别也在于此。因为静态代理是字节码一上来就创建好，并完成加载。
    1、基于接口的动态代理，JDK 官方的 Proxy 类
    2、基于子类的动态代理，CGLib类

AOP 相关术语

- Joinpoint(连接点 ): 谓连接点是指那些被拦截到的点。在 spring 中,这些点指的是方法,因为 spring 只支持方法类型的连接点。
- Pointcut(切入点 ): 所谓切入点是指我们要对哪些 Joinpoint 进行拦截的定义。
- Advice(通知/增强): 所谓通知是指拦截到 Joinpoint 之后所要做的事情就是通知。 通知的类型:前置通知,后置通知,异常通知,最终通知,环绕通知。
- Introduction(引介 ): 引介是一种特殊的通知在不修改类代码的前提下, Introduction 可以在运行期为类动态地添加一些方法或 Field。
- Target(目标对象 ): 代理的目标对象。
- Weaving(织入 ): 是指把增强应用到目标对象来创建新的代理对象的过程。spring 采用动态代理织入，而 AspectJ 采用编译期织入和类装载期织入。
- Proxy(代理) : 一个类被 AOP 织入增强后，就产生一个结果代理类。
- Aspect(切面 ): 是切入点和通知(引介)的结合

Spring 框架监控切入点方法的执行。一旦监控到切入点方法被运行，使用代理机制，动态创建目标对 象的代理对象，根据通知类别，在代理对象的对应位置，将通知对应的功能织入，完成完整的代码逻辑运行。在spring 中，框架会根据目标类是否实现了接口来决定采用哪种动态代理的方式。


切入点表达式
```
全匹配方式:
    public void com.itheima.service.impl.AccountServiceImpl.saveAccount(com.itheima.domain.Account)
访问修饰符可以省略
    void com.itheima.service.impl.AccountServiceImpl.saveAccount(com.itheima.domain.Account)
返回值可以使用*号，表示任意返回值 *
    com.itheima.service.impl.AccountServiceImpl.saveAccount(com.itheima.domain.Account) 
包名可以使用*号，表示任意包，但是有几级包，需要写几个*
    * *.*.*.*.AccountServiceImpl.saveAccount(com.itheima.domain.Account)
使用..来表示当前包，及其子包
    * com..AccountServiceImpl.saveAccount(com.itheima.domain.Account)
类名可以使用*号，表示任意类
    * com..*.saveAccount(com.itheima.domain.Account)
方法名可以使用*号，表示任意方法
    * com..*.*( com.itheima.domain.Account) 
参数列表可以使用*，表示参数可以是任意数据类型，但是必须有参数
    * com..*.*(*) 
参数列表可以使用..表示有无参数均可，有参数可以是任意类型
    * com..*.*(..)
全通配方式:
    * *..*.*(..)

通常情况下，我们都是对业务层的方法进行增强，所以切入点表达式都是切到业务层实现类。
    execution(* com.itheima.service.impl.*.*(..))
```

