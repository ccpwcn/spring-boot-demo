# 1. 概述
这是一个SpringBoot+SpringCloud的学习笔记工程，在这里，我会将学习和使用过程中遇到的所有问题都提交到这里，让后来者少走弯路。

# 2. 工程初始化过程
1. 新建Maven工程空工程
2. 聚合父工程名称，统一版本子module
3. Maven选择版本，一般使用3.6.0以上版本，不推荐使用IDEA自带的maven
4. 工程名称定义，名称定义要求：业务强关联、见名知义、不冗长
5. 字符编码设置一致，统一使用UTF-8
6. 注解生效激活，有利于代码、配置、注解的开发联动，提升效率
7. 设置Java编译器版本，统一设置为JDK8
8. 必要时设置IDEA的File Type过滤
> 工程目录下加入到版本管理的，仅限src目录、pom文件、.gitignore和其他运行所必须的文件、文档。IDE自已生成的各类文件、开发/调试期间生成的各类临时文件和配置文件，一律不加入版本管理。

# 3.设计
使用一个统一的父工程预设好所有第三方依赖的版本，统一管理，可以最大限度的避免出现经常碰到的jar包冲突问题。

## 3.1 业务逻辑代码控制

## 3.2 缓存
缓存是必不可少的，官方推荐的，也是现在业界流行的，是`Redisson`。

# 4. 实用技巧
在一个接口或类上面，按CTRL+Q快捷键，可以快速打开此类或接口的注释文档，对于查看了解JDK自带的类和接口，是十分有用的。

---
---
---

# 中文学习笔记

# 前言
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

**怎么实现自动装配的排除呢？**
提出这个需求的初衷是什么呢？答案是：虽然SpringBoot的自动装配机制很好，帮助我们省去了很多麻烦事，但是凡事无绝对，有的时候，我们就还真的不需要它的自动装配机制。
比如说：Spring框架自带的Quartz（定时任务），我就不想让它自动装配，而是想要使用我自己写的，此时，也很简单，只需要在Main入口类的`@SpringBootApplication`注解上添加`exclude`值就可以了，如下所示：
```java
@SpringBootApplication(exclude = QuartzAutoConfiguration.class);
```

## @ComponentScan
这个注解其实大家应该是比较熟悉的，它和SpringMVC时代的配置文件中指定要扫描的包的那个xml配置是同一个东西，看下面这个：
```xml
<context:component-scan base-package="com.example.package.name" />
```
需要注意的是：默认情况下，SpringBoot会扫描main方法所在类（也就是程序入口启动类）的包，所以，通常情况下我们都是将其他的controller、service、dao等包放到启动类所在包的子包中，就能自动扫描了，所以不需要配置这个ComponentScan。

# SpringBoot的配置文件
SpringBoot的配置文件，支持传统的properties和新的yaml两种格式，使用更简洁方便的是yaml，所以我们在这里也介绍它。

使用配置文件只需要注意两个点即可，很简单的：
1. 配置文件的格式要写正确，这个只需要细心就可以了
2. 配置文件可以区分环境，这里有几个诀窍介绍给大家：
    1. 默认的配置文件application.yml中，一般不会写具体的配置，只会指明要激活的配置
    2. 使用application-dev.yml、application-test.yml、application-demo.yml、application-pro.yml等形式区分开发环境、测试环境、演示环境、生产环境等等。
    3. 激活配置文件时，在IDE中指定运行配载即可，在服务器上运行jar包时使用类似于这样的命令行参数`--spring.profiles.active=dev`即可激活指定的配置文件。
    4. 当我们已经把jar包打好了之后，不改代码的情况下，又想修改配置文件中的内容，比如数据库连接密码，此时不必修改配置文件再重新打包，只需要把新的配置项放到一个和原来文件名一样的新文件中，再将这个新文件和jar包到一起，再重新启动jar包即可覆盖jar包中resources目录下的配置。

# 绑定和加载自定义的配置文件项
这一块的功能是很常用的，通常我们都会将一些灵活的业务策略放在配置文件中，然后在代码中加载使用，在这里给大家推出最简攻略和最佳实践。

## 第一步：将要配置的项放在resources目录中的yml文件中：
```yaml
password:
  salt-type: TIMESTAMP
  min-len: 6
  max-len: 30
```
## 第二步：定义一个类，如下所示：
```java
@Configuration
@ConfigurationProperties("password")
public class PasswordConf {
    private String saltType;
    private int minLen;
    private int maxLen;

    // 在这里放getters和setters，不能省略
}
```
第三步：在其他地方使用，如下示例：
```java
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private PasswordConf passwordConf;

    @GetMapping("/password")
    public String password() {
        return passwordConf.getSaltType();
    }
}
```

**简单！完美！**

上述示例代码在本仓库中的user-service模块中有。

