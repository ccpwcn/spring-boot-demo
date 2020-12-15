# 中文学习笔记
## 前言
在Spring项目中，可以使用`@Autowired`和`@Resource`两种方式注入Bean，被注入的Bean，是必须要在Spring容器中的。这两种方式是有区别的，并且，`@Resource`是可以指定name的，如果指定了，它的优先级是最高的。

# SpringBoot注解
## @SpringBootConfiguration
这个注解其实就是Spring的Configuration注解，这也从另外一个方面解答了为什么SpringBoot的启动类上可以使用方法将一些Bean注入到Spring容器中去，因为启动类本身就在Spring容器中啊。

## @EnableAutoConfiguration
这个注解是用来帮助我们实现自动装配的。

怎么实现自动装配呢？
- SpringBoot项目在启动的时候，会执行一个名叫`SpringFactoriesLoader`的类，这个类有一个静态成员，叫`org.springframework.core.io.support.SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION`，复制它的值`META-INF/spring.factories`
- 在IDEA中双击SHIFT键，选择All，就会找到项目所依赖的spring-boot-autoconfigure-2.2.6.RELEASE-sources.jar中找到一个META-INF/spring.factories的文本文件
- 在这个文本文件中，就会有很多很多自动装配的类，其中有一个名叫`org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration`的自动装配类
- 按住CTRL键点击这个类名，就会跟踪进入这个类的声明定义的位置
