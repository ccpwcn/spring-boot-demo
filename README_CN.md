# 中文学习笔记
## 前言
在Spring项目中，可以使用`@Autowired`和`@Resource`两种方式注入Bean，被注入的Bean，是必须要在Spring容器中的。这两种方式是有区别的，并且，`@Resource`是可以指定name的，如果指定了，它的优先级是最高的。

看本文档需要注意两点：
1. 很熟悉Spring、SpringMVC的情况下，再研究SpringBoot，事半功倍。
2. 本文档基于SpringBoot 2.2.6，其他版本可能略有不同。

很厉害很厉害的人曾经讲过，选择大于努力，所以我们要选择SpringBoot而不是SpringMVC，要选择SpringBoot2.x而不是SpringBoot1.x，另外，MyBatisPlus还是很好用的，可以省去很多麻烦，MyBatisCodeHelper也是极品好物，省下来的时间都是自己的，就不要计较一年59块钱了，你随随便干点啥花的钱都不止这个数，何必要跟自己过不去呢？

# SpringBoot注解
## @SpringBootConfiguration
这个注解是一个复合注解（也可称为派生注解），它其实就是Spring的Configuration注解，这也从另外一个方面解答了为什么SpringBoot的启动类上可以使用方法将一些Bean注入到Spring容器中去，因为启动类本身就在Spring容器中啊。

## @EnableAutoConfiguration
这个注解是用来帮助我们实现自动装配的。
打开这个注解的定义，我们可以看到，其关键功能由注解`@Import`提供，这个`@Import`注解导入了一个名叫`org.springframework.boot.autoconfigure.AutoConfigurationImportSelector`的类，
在这个类中，我们要**特别注意`org.springframework.boot.autoconfigure.AutoConfigurationImportSelector.selectImports`**这个方法，在这个方法中，进一步跟踪`org.springframework.boot.autoconfigure.AutoConfigurationImportSelector.getAutoConfigurationEntry`，再进一步跟踪`org.springframework.boot.autoconfigure.AutoConfigurationImportSelector.getCandidateConfigurations`，就可以看到这么一行代码：`List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(), getBeanClassLoader());`，
这行代码的功能是扫描所有的具有META-INF/spring.factories的jar包，SpringBoot项目依赖项中，有很多spring-boot-autoconfigure-x.jar中就有这样的spring.factories文件。


**怎么实现自动装配呢？**
- SpringBoot项目在启动的时候，会执行一个名叫`SpringFactoriesLoader`的类，这个类有一个静态成员，叫`org.springframework.core.io.support.SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION`，复制它的值`META-INF/spring.factories`
- 在IDEA中双击SHIFT键，选择All，就会找到项目所依赖的spring-boot-autoconfigure-2.2.6.RELEASE-sources.jar中找到一个META-INF/spring.factories的文本文件
- 在这个文本文件中，就会有很多很多自动装配的类，其中有一个名叫`org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration`的自动装配类
- 按住CTRL键点击这个类名，就会跟踪进入这个类的声明定义的位置
- 在这个类的声明位置，可以看到一个名为`org.springframework.boot.autoconfigure.AutoConfigureAfter`的注解，它明确的指定了要在自动装配的时候加载和装配`org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration`
- 而被指明的这个`org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration`就是用来初始化Spring项目的DispatcherServlet的，熟悉Spring的我们都知道，这是Spring Web项目的核心

