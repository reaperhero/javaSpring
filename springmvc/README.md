# springmvc

## 原理解析

1. SpringMVC运行原理

![SpringMVC运行原理](https://img-blog.csdnimg.cn/20200418161602129.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwMTgxNDM1,size_16,color_FFFFFF,t_70)


2. 运行原理解析

![启动流程](https://img-blog.csdnimg.cn/2020041910481013.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwMTgxNDM1,size_16,color_FFFFFF,t_70)


## 常用注解

@RequestMapping
```
path：指定映射路径
method = {RequestMethod.POST,RequestMethod.GET}
params:指定限制请求参数的条件,它支持简单的表达式,属性只要出现2个或以上时，他们的关系是与关系
    params = {"accountName"}，则请求参数必须有accountName
    params = {"accountName=heihei"}，则请求参数必须是accountName=heihei
    params = {"money！100"}，表示请求参数中的money不能是100
```


## 类型转换器

网页传参都是String格式，而SpringMVC在传参的过程中自动进行了类型转换,但是也有个别案例。如：默认可转换的日期格式为 yyyy/MM/dd，如果输入日期格式为 yyyy-MM-dd，则会报错。SpringMVC为我们提供了一个接口，用于我们自己编写转换代码

```
在主配置文件springmvc.xml文件中配置,配置自定义类型转换器

<bean id="conversionServiceFactoryBean" class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters">
        <set>
            <!--配置路径-->
            <bean class="it.mvc.utiles.StringToDateConverter"></bean>
        </set>
    </property>
</bean>

<!--开启springmvc框架注解支持  手动开启类型转换-->
<mvc:annotation-driven conversion-service="conversionServiceFactoryBean"/>
```