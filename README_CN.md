# 中文学习笔记
## 前言
在Spring项目中，可以使用`@Autowired`和`@Resource`两种方式注入Bean，被注入的Bean，是必须要在Spring容器中的。这两种方式是有区别的，并且，`@Resource`是可以指定name的，如果指定了，它的优先级是最高的。

# SpringBoot注解
## @SpringBootConfiguration
这个注解其实就是Spring的Configuration注解，这也从另外一个方面解答了为什么SpringBoot的启动类上可以使用方法将一些Bean注入到Spring容器中去，因为启动类本身就在Spring容器中啊。

## @EnableAutoConfiguration
这个注解是用来帮助我们实现自动装配的。

怎么实现自动装配呢？SpringBoot项目在启动的时候，会执行一个名叫`SpringFactoriesLoader`的类，这个类有一个静态成员，叫