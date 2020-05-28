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

@RequestParam()
```
value：请求参数中的名称,当添加了注解之后，网页传参的参数名称必须与注解中的一致，否则会报错
required：请求参数中是否必须提供此参数。默认值为true。表示必须提供，不提供会出错
```

@RequestBody()
```
作用：用于获取请求体内容。直接使用得到的是 key=value&key=value结构的数据,用于post请求，get方式不适用
required：是否必须有请求体，默认为true。 当取值为true时，get请求方式会报错。如果取值为false，get请求得到的是null
```

@PathVariable()
```
作用：用于绑定url中的占位符。例如：请求url中/delete/{id}，这个{id}就是占位符
value：用于指定url中占位符的位置
required：是否必须提供占位符
```

@CookieValue()
```
作用：用于把指定cookie名称的值传入控制器方法参数
value：指定cookie的名称
required：是否必须有cookie
```

@ModelAttribute()
```
作用：该注解是springmvc4.3版本之后加入的，他可以用于修饰方法和参数

出现在方法上：表示当前方法会在控制器执行之前执行。它可以修饰没有返回值的方法，也可以修饰有具体返回值的方法
出现在参数上，获取指定的数据给参数赋值

value：用于获取数据的key。key可以是POJO的属性名称，也可以是map结构的key
```

@SessionAttributes()
```
作用：需要在类上加SessionAttributes注解，用于多次执行控制器方法间的参数共享

value：用于指定存入的属性名称
type：用于指定存入的数据类型
```


@RequestHeader()
```
作用：用于获取请求消息头
value：提供消息头名称
required：是否必须有此消息头
```


## 响应和结果视图

- 返回值是String类型: 内部的实现原理还是ModelAndView
- 返回值是void类型: 会默认寻找与请求路径相同的jsp，可以用原生servlet响应
- 返回值是ModelAndView
- 请求转发、重定向


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