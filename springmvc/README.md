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