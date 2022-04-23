# 1、Spring概述
## 1.1、简介
+ Spring：春天----->给软件行业带来了春天。
+ 2002，首次推出了Spring框架的雏形：interface21框架。
+ Spring框架是以interface21框架为基础，经过重新设计，并不断丰富内涵，于2004年3月24日发布了1.0正式版。
+ **Rod Johnson**,Spring Framework创始人，著名作家。很难想象Rod Johnson的学历，真的让好多人大吃一惊，他是悉尼大学的博士，然而他的专业不是计算机，而是音乐学。
+ Spring理念：使现有的技术更加容易使用，本身就是一个大杂烩，整合了现有的技术框架。

---

+ SSH：Struct2+Spring+Hibernate
+ SSM：SpringMVC+Spring+Mybatis

官网：[https://spring.io/projects/spring-framework#overview](https://spring.io/projects/spring-framework#overview)  
官方下载地址：[https://repo.spring.io/libs-release-local/org/springframework/spring/](https://repo.spring.io/libs-release-local/org/springframework/spring/)  
GitHub : [https://github.com/spring-projects](https://github.com/spring-projects "SpringFramework框架GitHub地址")

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.19</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.19</version>
</dependency>
```

## 1.2、优点
+ Spring是一个开源免费的框架（容器）！
+ Spring是一个轻量级的、非入侵式的框架！
+ 控制反转（IOC）,面向切面编程（AOP）！
+ 支持事务的处理，对框架整合的支持！

**Spring就是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架！**

## 1.3、组成
![](img/Spring-组成01.png)  
Spring 框架是一个分层架构，由 7 个定义良好的模块组成。Spring 模块构建在核心容器之上，核心容器定义了创建、配置和管理 bean 的方式 .  
![](img/Spring-组成02.png)  
组成 Spring 框架的每个模块（或组件）都可以单独存在，或者与其他一个或多个模块联合实现。每个模块的功能如下：
+ **核心容器**：核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 BeanFactory，它是工厂模式的实现。BeanFactory 使用控制反转（IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。
+ **Spring 上下文**：Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。
+ **Spring AOP**：通过配置管理特性，Spring AOP 模块直接将面向切面的编程功能 , 集成到了 Spring 框架中。所以，可以很容易地使 Spring 框架管理任何支持 AOP的对象。Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖组件，就可以将声明性事务管理集成到应用程序中。
+ **Spring DAO**：JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵从通用的 DAO 异常层次结构。
+ **Spring ORM**：Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。
+ **Spring Web 模块**：Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与 Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。
+ **Spring MVC 框架**：MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText 和 POI。

## 1.4、拓展
**Spring Boot**与**Spring Cloud**
+ Spring Boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务;
+ Spring Cloud是基于Spring Boot实现的；
+ Spring Boot专注于快速、方便集成的单个微服务个体，Spring Cloud关注全局的服务治理框架；
+ Spring Boot使用了约束优于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置 , Spring Cloud很大的一部分是基于Spring Boot来实现，Spring Boot可以离开Spring Cloud独立使用开发项目，但是Spring Cloud离不开Spring Boot，属于依赖的关系。
+ SpringBoot在SpringClound中起到了承上启下的作用，如果你要学习SpringCloud必须要学习SpringBoot。

![](img/Spring-02.png)

---

弊端：发展了太久之后，违背了原本的理念！配置十分繁琐，人称：“配置地狱”！ 

# 2、IOC理论推导
## 2.1、IOC基础
新建一个空白的maven项目
**分析实现**
我们先用我们原来的方式写一段代码
1. 先写一个UserDao接口
```java
public interface UserDao {
   public void getUser();
}
```

2. 再去写Dao的实现类
```java
public class UserDaoImpl implements UserDao {
   @Override
   public void getUser() {
       System.out.println("获取用户数据");
  }
}
```

3. 然后去写UserService的接口
```java
public interface UserService {
   public void getUser();
}
```

4. 最后写Service的实现类
```java
public class UserServiceImpl implements UserService {
   private UserDao userDao = new UserDaoImpl();

   @Override
   public void getUser() {
       userDao.getUser();
  }
}
```

5、测试一下
```java
@Test
public void test(){
   UserService service = new UserServiceImpl();
   service.getUser();
}
```
---

这是我们原来的方式 , 开始大家也都是这么去写的对吧 . 那我们现在修改一下
把Userdao的实现类增加一个
```java
public class UserDaoMySqlImpl implements UserDao {
   @Override
   public void getUser() {
       System.out.println("MySql获取用户数据");
  }
}
```

紧接着我们要去使用MySql的话 , 我们就需要去service实现类里面修改对应的实现
```java
public class UserServiceImpl implements UserService {
   private UserDao userDao = new UserDaoMySqlImpl();

   @Override
   public void getUser() {
       userDao.getUser();
  }
}
```
再假设, 我们再增加一个Userdao的实现类
```java
public class UserDaoOracleImpl implements UserDao {
   @Override
   public void getUser() {
       System.out.println("Oracle获取用户数据");
  }
}
```
那么我们要使用Oracle，又需要去service实现类里面修改对应的实现，假设我们的这种需求非常大，这种方式就根本不适用了，甚至反人类对吧，每次变动，都需要修改大量代码，这种设计的耦合性太高了，牵一发而动全身。

---

**那我们如何去解决呢？**
我们可以在需要用到他的地方，不去实现它，而是留出一个接口，利用set，我们去代码里修改下。
```java
public class UserServiceImpl implements UserService {
   private UserDao userDao;
// 利用set实现
   public void setUserDao(UserDao userDao) {
       this.userDao = userDao;
  }

   @Override
   public void getUser() {
       userDao.getUser();
  }
}
```
现在去我们的测试类里，进行测试；
```java
@Test
public void test(){
   UserServiceImpl service = new UserServiceImpl();
   service.setUserDao( new UserDaoMySqlImpl() );
   service.getUser();
   //那我们现在又想用Oracle去实现呢
   service.setUserDao( new UserDaoOracleImpl() );
   service.getUser();
}
```
这里已经发生了根本性的变化，很多地方都不一样了。以前所有东西都是由程序去进行控制创建，而现在是由我们自行控制创建对象，把主动权交给了调用者。程序不用去管怎么创建、怎么实现了。它只负责提供一个接口。

这种思想，从本质上解决了问题，我们程序员不再去管理对象的创建了，更多的去关注业务的实现。耦合性大大降低。这也就是IOC的原型！


## 2.2、IOC本质
**控制反转IoC(Inversion of Control)，是一种设计思想，DI(依赖注入)是实现IoC的一种方法**，也有人认为DI只是IoC的另一种说法。没有IoC的程序中 , 我们使用面向对象编程 , 对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是：获得依赖对象的方式反转了。

![](img/02-IOC%E7%90%86%E8%AE%BA%E6%8E%A8%E5%AF%BC01.png)

**IOC是Spring框架的核心内容**，使用多种方式完美的实现了IoC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IoC。

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。

![](img/02-IOC%E7%90%86%E8%AE%BA%E6%8E%A8%E5%AF%BC02.png)

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

**控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection,DI）。**

# 3、HelloSpring
## 3.1、导入Jar包

注 : spring 需要导入commons-logging进行日志记录 . 我们利用maven , 他会自动下载对应的依赖项 .
```xml
<dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-webmvc</artifactId>
   <version>5.1.10.RELEASE</version>
</dependency>
```
## 3.2、编写代码

1、编写一个Hello实体类
```java
public class Hello {
private String name;

public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}

public void show(){
System.out.println("Hello,"+ name );
}
}
```
2、编写我们的spring文件 , 这里我们命名为beans.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

   <!--bean就是java对象 , 由Spring创建和管理-->
   <bean id="hello" class="com.kuang.pojo.Hello">
       <property name="name" value="Spring"/>
   </bean>

</beans>
```
3、我们可以去进行测试了 .
```java
@Test
public void test(){
//解析beans.xml文件 , 生成管理相应的Bean对象
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//getBean : 参数即为spring配置文件中bean的id .
Hello hello = (Hello) context.getBean("hello");
hello.show();
}
```

## 3.3、思考

* Hello 对象是谁创建的?  
**hello 对象是由Spring创建的**

* Hello 对象的属性是怎么设置的？  
**hello 对象的属性是由Spring容器设置的**

这个过程就叫控制反转 :

**控制** : 谁来控制对象的创建 , 传统应用程序的对象是由程序本身控制创建的 , 使用Spring后 , 对象是由Spring来创建的

**反转** : 程序本身不创建对象 , 而变成被动的接收对象 .

**依赖注入** : 就是利用set方法来进行注入的.

IOC是一种编程思想，由主动的编程变成被动的接收

可以通过newClassPathXmlApplicationContext去浏览一下底层源码 .



## 3.4、修改案例一

我们在案例一中， 新增一个Spring配置文件beans.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

   <bean id="MysqlImpl" class="com.kuang.dao.impl.UserDaoMySqlImpl"/>
   <bean id="OracleImpl" class="com.kuang.dao.impl.UserDaoOracleImpl"/>

   <bean id="ServiceImpl" class="com.kuang.service.impl.UserServiceImpl">
       <!--注意: 这里的name并不是属性 , 而是set方法后面的那部分 , 首字母小写-->
       <!--引用另外一个bean , 不是用value 而是用 ref-->
       <property name="userDao" ref="OracleImpl"/>
   </bean>

</beans>
```
测试！
```java
@Test
public void test2(){
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
UserServiceImpl serviceImpl = (UserServiceImpl) context.getBean("ServiceImpl");
serviceImpl.getUser();
}
```
OK , 到了现在 , 我们彻底不用再程序中去改动了 , 要实现不同的操作 , 只需要在xml配置文件中进行修改 , 所谓的IoC,一句话搞定 : 对象由Spring 来创建 , 管理 , 装配 ! 


# 4、IOC创建对象方式

## 4.1、通过无参构造方法来创建

1、User.java
```java
public class User {

private String name;

public User() {
System.out.println("user无参构造方法");
}

public void setName(String name) {
this.name = name;
}

public void show(){
System.out.println("name="+ name );
}

}
```
2、beans.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

   <bean id="user" class="com.kuang.pojo.User">
       <property name="name" value="kuangshen"/>
   </bean>

</beans>
```
3、测试类
```java
@Test
public void test(){
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//在执行getBean的时候, user已经创建好了 , 通过无参构造
User user = (User) context.getBean("user");
//调用对象的方法 .
user.show();
}
```
结果可以发现，在调用show方法之前，User对象已经通过无参构造初始化了！



## 4.2、通过有参构造方法来创建

1、UserT . java
```java
public class UserT {

private String name;

public UserT(String name) {
this.name = name;
}

public void setName(String name) {
this.name = name;
}

public void show(){
System.out.println("name="+ name );
}

}
```
2、beans.xml 有三种方式编写
```xml
<!-- 第一种根据index参数下标设置 -->
<bean id="userT" class="com.kuang.pojo.UserT">
   <!-- index指构造方法 , 下标从0开始 -->
   <constructor-arg index="0" value="kuangshen2"/>
</bean>
<!-- 第二种根据参数名字设置 -->
<bean id="userT" class="com.kuang.pojo.UserT">
   <!-- name指参数名 -->
   <constructor-arg name="name" value="kuangshen2"/>
</bean>
<!-- 第三种根据参数类型设置 -->
<bean id="userT" class="com.kuang.pojo.UserT">
   <constructor-arg type="java.lang.String" value="kuangshen2"/>
</bean>
```
3、测试
```java
@Test
public void testT(){
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
UserT user = (UserT) context.getBean("userT");
user.show();
}
```
结论：在配置文件加载的时候。其中管理的对象都已经初始化了！

# 5、Spring配置
## 5.1、别名

alias 设置别名 , 为bean设置别名 , 可以设置多个别名
```xml
<!--设置别名：在获取Bean的时候可以使用别名获取-->
<alias name="userT" alias="userNew"/>
```

## 5.2、Bean的配置
```xml
<!--bean就是java对象,由Spring创建和管理-->

<!--
   id 是bean的标识符,要唯一,如果没有配置id,name就是默认标识符
   如果配置id,又配置了name,那么name是别名
   name可以设置多个别名,可以用逗号,分号,空格隔开
   如果不配置id和name,可以根据applicationContext.getBean(.class)获取对象;

class是bean的全限定名=包名+类名
-->
<bean id="hello" name="hello2 h2,h3;h4" class="com.kuang.pojo.Hello">
   <property name="name" value="Spring"/>
</bean>
```

## 5.3、import
团队的合作通过import来实现
假设，现在项目中有多个人开发，这三个人复制不同的类开发，不同的类需要注册在不同的bean中，我们可以利用import将所有人的beans.xml合并为一个总的！
* 张三
* 李四
* 王五
* applicationContext.xml

```xml
<import resource="{path}/beans.xml"/>
<import resource="{path}/beans2.xml"/>
<import resource="{path}/beans3.xml"/>
```

使用的时候，直接使用总的配置就可以了


# 6、依赖注入

## 6.1、构造器注入
前面已经说过了


## 6.2、set方式注入【重点】
* 依赖注入：set注入！  
  * 依赖：bean对象的创建依赖于容器！
  * 注入：bean对象中的所有属性，由容器来注入！
  
【环境搭建】
1. 复杂类型
```java
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```
2. 真事测试对象
```java
public class Student {
    private String name;
    private Address address;
    private String[] book;
    private List<String> hobbies;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;
}
```
3. beans.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="student" class="com.wugang.pojo.Student">
        <!-- 第一种：普通值注入，value -->
        <property name="name" value="张三"/>
    </bean>
</beans>
```
4. 测试类
```java
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");

        System.out.println(student.getName());
    }
}
```

完善注入信息
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="address" class="com.wugang.pojo.Address">
        <property name="address" value="林荫大道108号"/>
    </bean>

    <bean id="student" class="com.wugang.pojo.Student">
        <!-- 普通值注入，value -->
        <property name="name" value="张三"/>

        <!-- bean注入，ref -->
        <property name="address" ref="address"/>

        <!-- 数组注入，ref -->
        <property name="book">
            <array>
                <value>三国演义</value>
                <value>水浒传</value>
                <value>西游记</value>
                <value>红楼梦</value>
            </array>
        </property>

        <!-- List注入 -->
        <property name="hobbies">
            <list>
                <value>听歌</value>
                <value>看电影</value>
                <value>打篮球</value>
            </list>
        </property>

        <!-- Map -->
        <property name="card">
            <map>
                <entry key="身份证" value="123456789456321598"/>
                <entry key="银行卡" value="12345678945652159875"/>
            </map>
        </property>

        <!-- Set -->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>DNF</value>
            </set>
        </property>

        <!-- Null -->
        <property name="wife">
            <null/>
        </property>

        <!-- Properties -->
        <property name="info">
            <props>
                <prop key="driver">201612085</prop>
                <prop key="url">男</prop>
                <prop key="username">男</prop>
                <prop key="password">男</prop>
            </props>
        </property>
    </bean>
</beans>
```

## 6.3、拓展方式注入

我们可以使用p命名空间和c命名空间进行注入  
官方解释：
![](img/p%E5%91%BD%E5%90%8D%E7%A9%BA%E9%97%B4%E6%B3%A8%E5%85%A5.png)
![](img/c命名空间注入.png)

使用：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- p命名空间注入，可以直接注入属性的值：property -->
    <bean id="user" class="com.wugang.pojo.User" p:name="李四" p:age="18"/>

    <!-- c命名空间注入，通过构造器注入：construct-orgs -->
    <bean id="user2" class="com.wugang.pojo.User" c:name="王五" c:age="108"/>
</beans>
```

测试：
```java
@Test
public void test2() {
   ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
   User user = context.getBean("user2", User.class);

   System.out.println(user);
}
```

注意点：p命名和c命名空间不能直接使用，需要导入xml约束！
```xml
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"
```

## 6.4、bean的作用域
![](img/bean的作用域.png)

1. 单例模式（Spring默认机制）
   ![](img/单例模式.png)
   ```xml
   <bean id="user2" class="com.wugang.pojo.User" c:name="王五" c:age="108" scope="singleton"/>
   ```
2. 原型模式：每次从容器中get的时候，都会产生一个新对象！
   ![](img/原型模式.png)
   ```xml
   <bean id="user2" class="com.wugang.pojo.User" c:name="王五" c:age="108" scope="prototype"/>
   ```
3. 其余的request、session、application，这些只能在web开发中使用到！

# 7、Bean的自动装配

* 自动装配是Spring满足bean依赖的一种方式！
* Spring会在上下文中自动寻找，并自动给bean装配属性！


在Spring中有三种装配的方式
1. 在xml中显示的配置
2. 在java中显示配置
3. 隐式的自动装配bean 【重要】

## 7.1、测试
环境搭建：一个人有两个宠物！
```java
public class People {
    private Cat cat;
    private Dog dog;
    private String name;
}

public class Cat {
    public void shout(){
        System.out.println("miao");
    }
}

public class Dog {
    public void shout(){
        System.out.println("wang");
    }
}
```

```xml
<bean id="cat" class="com.wugang.pojo.Cat"/>
<bean id="dog" class="com.wugang.pojo.Dog"/>

<bean id="people" class="com.wugang.pojo.People">
   <property name="name" value="周吴郑王"/>
   <property name="cat" ref="cat"/>
   <property name="dog" ref="dog"/>
</bean>
```

```java
@Test
public void test1() {
   ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
   People people = context.getBean("people", People.class);

   people.getCat().shout();
   people.getDog().shout();
}
```

## 7.2、byName自动装配
```xml
<!--
byName：会自动在容器上下文查找和自己对象set方法后面的值对应的beanid！
-->
<bean id="people" class="com.wugang.pojo.People" autowire="byName">
   <property name="name" value="周吴郑王"/>
</bean>
```

## 7.3、byType自动装配
```xml
<bean class="com.wugang.pojo.Cat"/>
<bean class="com.wugang.pojo.Dog"/>

<!--
byName：会自动在容器上下文查找和自己对象set方法后面的值对应的beanid！id和set方法后面的值名称必须相同，否则找不到
byType：会自动在容器上下文查找和自己对象属性类型相同的bean！此时被装配对象bean的id可以省略
-->
<bean id="people" class="com.wugang.pojo.People" autowire="byType">
   <property name="name" value="周吴郑王"/>
</bean>
```

小结：
* byName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
* byType的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的属性的类型一致！

## 7.4、 使用注解实现自动装配

jdk1.5支持的注解，Spring2.5就支持注解了。  
The introduction of annotation-based configuration raised the question of whether this approach is “better” than XML.

要使用注解须知：
1. 导入约束，context约束
2. **配置注解的支持：<context:annotation-config/>【重要】**
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

   </beans>
   ```

@Autowired
直接在属性上使用即可！也可以在set方式上使用！  
使用Autowired时我们可以不用编写set方法，前提是你这个自动装配的属性在IOC（Spring）容器中存在，且符合名字byName！  
科普：
```java
@Nullable   若某个字段使用了这个注解，说明这个字段可以为null；
```

```java
public @interface Autowired {
    boolean required() default true;
}
```

测试代码：
```java
public class People {
    //如果显示定义了Autowired的required属性为false，说明这个对象可以为null，否则不允许为空
    @Autowired(required = false)
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;
}
```

如果@Autowired自动装配的环境比较复杂，自动装配无法通过一个注解[@Autowired]完成的时候，我们可以使用@Qualifier(value = "xxx")去配合@Autowired的使用，指定一个唯一的bean对象注入！
```xml
<bean id="cat" class="com.wugang.pojo.Cat"/>
<bean id="cat111" class="com.wugang.pojo.Cat"/>
<bean id="dog" class="com.wugang.pojo.Dog"/>
<bean id="dog222" class="com.wugang.pojo.Dog"/>
<bean id="people" class="com.wugang.pojo.People"/>
```
```java
public class People {
    @Autowired
    @Qualifier(value = "cat222")
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog222")
    private Dog dog;
    private String name;
}
```

**@Resource注解**
```java
public class People {
    @Resource(name = "cat1")
    private Cat cat;
    @Resource(name = "dog2")
    private Dog dog;
    private String name;
}
```


小结：
@Resource和@Autowired的区别：
* 都是用来自动装配的，都可雨放在属性字段上
* @Autowired 默认通过byType的方式实现，如果找不到，则通过byName实现，而且必须要求这个对象存在！【常用】
* @Resource 默认通过byName的方式实现，如果找不到名字，则通过byType实现！如果两个都找不到的情况下，就会报错！【常用】
* 执行顺序不同：@Autowired 通过byType的方式实现；@Resource 默认通过byName的方式实现

# 8、使用注解开发
在Spring4之后，要使用注解开发，必须要保证aop的包导入了
![](img/aop包.png)
使用注解需要导入context约束，增加注解的支持!
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
     https://www.springframework.org/schema/beans/spring-beans.xsd
     http://www.springframework.org/schema/context
     https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```
1. bean  
@Component：组件，放在类上，说明这个类被Spring管理了，就是bean！
```java
//等价于 <bean id="user" class="com.wugang.pojo.User"/>
//@Component 组件
@Component
public class User {
    public String name;
}
```

2. 属性如何注入
```java
@Component
public class User {
    
    public String name;
    
    //相当于 <property name="name" value="张三123456789"/>
    @Value("张三123456789")
    public void setName(String name) {
        this.name = name;
    }
}
```

3. 衍生的注解  
@Component 有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！
   * dao 【@Repository】
   * service 【@Service】
   * controller 【@Controller】  

这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean

4. 自动装配
   

5. 作用域  
@Scope("singleton")
```java
@Component
@Scope("singleton")
public class User {

    public String name;
}
```

6. 小结  
**xml与注解：** 
   * xml更加万能，适用于任何场景！维护简单方便
   * 注解 不是自己类使用不了，维护相对复杂！
  
   **xml与注解最佳实践：**
   * xml用来管理bean；
   * 注解只负责完成属性的注入；
   * 我们在使用的过程中，只需要注意一个问题：必须让注解生效，就需要开启注解的支持
      ```xml
      <!-- 指定要扫描的包，这个包下的注解就会生效 -->
      <context:component-scan base-package="com.wugang"/>
      <context:annotation-config/>
      ```
# 9、使用Java的方法配置Spring
我们现在要完全不使用Spring的xml配置了，全权交给java来做！  
JavaConfig是Spring的一个子项目，在Spring 4 之后，它成为了一个核心功能！
![](img/ApplicationContext的实现.png)

user类：
```java
//这个注解的意思：就是说明这个类被Spring接管了，注册到了容器中
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("张三AppConfig") //属性注入值
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```
config类（配置类）：
```java
package com.wugang.config;

import com.wugang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

 */
//这个也会被Spring容器托管，注册到容器中，因为它本身就是一个@Component
//@Configuration代表这是一个配置类，就和我们之前看的Beans.xml一样
@Configuration
@ComponentScan("com.wugang.pojo")
@Import(Config2.class)
public class Config {

    //注册一个bean，就相当于我们之前写的一个bean标签，
    //这个方法的名字就是相当于bean标签中的id属性
    //这个方法的返回值就相当于bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();  //就是返回要注入到bean的对象！
    }
}
```

测试类：
```java
public class Test {
    public static void main(String[] args) {
        //如果完全使用了配置类方式去做，我们就只能通过 AnnotationConfig 上下文来获取容器，通过配置类的class对象加载！
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        User user = (User) context.getBean("getUser");

        System.out.println(user.getName());
    }
}
```


这种纯Java的配置方式，在SpringBoot中随处可见！

---

# 10、代理模式
为什么要学习代理模式？  
因为这就是Spring AOP的底层！【Spring AOP 和 SpringMVC】  


代理模式的分类：
* 静态代理
* 动态代理

代理模式：  
![](img/代理模式.png)

## 10.1、静态代理
角色分析：
* 抽象角色：一般会使用接口或者抽象类来解决
* 真实角色：被代理的角色
* 代理角色：代理真实角色，代理真实角色后，我们一般会做一些附属操作
* 客户：访问代理对象对的人

代码步骤：
1. 接口
   ```java
    //租房
    public interface Rent {
        void rent();
    }
   ```
   
2. 真实角色
   ```java
    /**
    * 房东
    */
    public class Host implements Rent{

        @Override
        public void rent() {
            System.out.println("房东要出租房子！");
        }
    }
   ```
   
3. 代理角色
   ```java
    /**
    * 中介
    */
    public class Proxy implements Rent {
        private Host host;

        public Proxy() {
        }

        public Proxy(Host host) {
            this.host = host;
        }

        @Override
        public void rent() {
            seeHouse();
            host.rent();
            hetong();
            fare();
        }

        /**
        * 看房
        */
        public void seeHouse() {
            System.out.println("中介带你看房！");
        }

        /**
        * 签租赁合同
        */
        public void hetong() {
            System.out.println("签租赁合同！");
        }

        /**
        * 收中介费
        */
        public void fare() {
            System.out.println("收中介费！");
        }
    }
   ```
   
4. 客户端访问代理juese
   ```java
   public class Client {
        public static void main(String[] args) {
            //房东要租房子
            Host host = new Host();
            //代理，中介帮房东租房子，但是呢？代理角色一般会有一些附属操作！
            Proxy proxy = new Proxy(host);
            //你不用面对房东，直接找中介租房即可！
            proxy.rent();
        }
    }
   ```

代理模式的好处：
* 可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
* 公共业务就交给代理角色！实现了业务的分工！
* 公共业务发生扩展的时候，方便集中管理！

缺点：
* 一个真实角色就会产生一个代理角色：代码量会翻倍~代码效率会变低


## 10.2、加深理解
代码：
1. service接口：
   ```java
    public interface UserService {
        void add();
        void delete();
        void update();
        void query();
    }
   ```

2. service实现类：
   ```java
    /**
    * 真实对象
    */
    public class UserServiceImpl implements UserService{
        @Override
        public void add() {
            System.out.println("增加了一个用户");
        }

        @Override
        public void delete() {
            System.out.println("删除了一个用户");
        }

        @Override
        public void update() {
            System.out.println("修改了一个用户");
        }

        @Override
        public void query() {
            System.out.println("查询了一个用户");
        }

        //1.改动原有的业务代码，在公司中是大忌！
    }
   ```

3. servic实现类代理：
   ```java
    /**
    * 代理service实现类，增加一个log输出的方法
    */
    public class UserServiceProxy implements UserService{
        private UserServiceImpl userService;

        public void setUserService(UserServiceImpl userService) {
            this.userService = userService;
        }

        @Override
        public void add() {
            log("add");
            userService.add();
        }

        @Override
        public void delete() {
            log("delete");
            userService.delete();
        }

        @Override
        public void update() {
            log("update");
            userService.update();
        }

        @Override
        public void query() {
            log("query");
            userService.query();
        }

        /**
        * 日志方法
        * @param msg
        */
        public void log(String msg){
            System.out.println("[Debug] 使用了" + msg + "方法");
        }
    }
   ```
   
4. 客户端访问service：
   ```java
    public class Client {
        public static void main(String[] args) {
            UserServiceImpl userService = new UserServiceImpl();

            UserServiceProxy userServiceProxy = new UserServiceProxy();

            userServiceProxy.setUserService(userService);

            userServiceProxy.add();
        }
    }
   ```
重点理解其中的**思想**；  
**我们在不改变原来的代码的情况下，实现了对原有功能的增强，这是AOP中最核心的思想**

聊聊AOP：纵向开发，横向开发
![](img/聊聊AOP.png)

## 10.3、动态代理
* 动态代理和静态代理角色一样
* 动态代理的代理类是动态生成的，不是我们直接写好的！
* 动态代理分为两大类：基于接口的动态代理，基于类的动态代理
  * 基于接口的动态代理----JDK动态代理
  * 基于类的动态代理--cglib
  * 现在用的比较多的是 javasist 来生成动态代理

我们这里使用JDK的原生代码来实现，其余的道理都是一样的！


**JDK的动态代理需要了解两个类**：  
InvocationHandler：调用处理程序 和 Proxy：代理

【InvocationHandler：调用处理程序】  
![](img/InvocationHandler.png)
```java
Object invoke(Object proxy, 方法 method, Object[] args)；
//参数
//proxy - 调用该方法的代理实例
//method -所述方法对应于调用代理实例上的接口方法的实例。方法对象的声明类将是该方法声明的接口，它可以是代理类继承该方法的代理接口的超级接口。
//args -包含的方法调用传递代理实例的参数值的对象的阵列，或null如果接口方法没有参数。原始类型的参数包含在适当的原始包装器类的实例中，例如java.lang.Integer或java.lang.Boolean 。
```

【Proxy  : 代理】 
![](/img/Proxy1.png)
![](img/Proxy2.png)
![](/img/Proxy3.png)
```java
//生成代理类
public Object getProxy(){
   return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                                 rent.getClass().getInterfaces(),this);
}
```

**代码实现**
抽象角色和真实角色和之前的一样！
Rent . java 即抽象角色
```java
//抽象角色：租房
public interface Rent {
   public void rent();
}
```

```java
Host . java 即真实角色

//真实角色: 房东，房东要出租房子
public class Host implements Rent{
   public void rent() {
       System.out.println("房屋出租");
  }
}
```

ProxyInvocationHandler. java 即代理角色
```java
public class ProxyInvocationHandler implements InvocationHandler {
   private Rent rent;

   public void setRent(Rent rent) {
       this.rent = rent;
  }

   //生成代理类，重点是第二个参数，获取要代理的抽象角色！之前都是一个角色，现在可以代理一类角色
   public Object getProxy(){
       return Proxy.newProxyInstance(this.getClass().getClassLoader(),
               rent.getClass().getInterfaces(),this);
  }

   // proxy : 代理类 method : 代理类的调用处理程序的方法对象.
   // 处理代理实例上的方法调用并返回结果
   @Override
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       seeHouse();
       //核心：本质利用反射实现！
       Object result = method.invoke(rent, args);
       fare();
       return result;
  }

   //看房
   public void seeHouse(){
       System.out.println("带房客看房");
  }
   //收中介费
   public void fare(){
       System.out.println("收中介费");
  }

}
```

Client . java
```java
//租客
public class Client {

   public static void main(String[] args) {
       //真实角色
       Host host = new Host();
       //代理实例的调用处理程序
       ProxyInvocationHandler pih = new ProxyInvocationHandler();
       pih.setRent(host); //将真实角色放置进去！
       Rent proxy = (Rent)pih.getProxy(); //动态生成对应的代理类！
       proxy.rent();
  }

}
```
核心：**一个动态代理 , 一般代理某一类业务 , 一个动态代理可以代理多个类，代理的是接口！**


**深化理解**
我们来使用动态代理实现代理我们后面写的UserService！  
我们也可以编写一个通用的动态代理实现的类！所有的代理对象设置为Object即可！  
```java
public class ProxyInvocationHandler implements InvocationHandler {
   private Object target;

   public void setTarget(Object target) {
       this.target = target;
  }

   //生成代理类
   public Object getProxy(){
       return Proxy.newProxyInstance(this.getClass().getClassLoader(),
               target.getClass().getInterfaces(),this);
  }

   // proxy : 代理类
   // method : 代理类的调用处理程序的方法对象.
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       log(method.getName());
       Object result = method.invoke(target, args);
       return result;
  }

   public void log(String methodName){
       System.out.println("执行了"+methodName+"方法");
  }

}
```

测试！
```java
public class Test {
   public static void main(String[] args) {
       //真实对象
       UserServiceImpl userService = new UserServiceImpl();
       //代理对象的调用处理程序
       ProxyInvocationHandler pih = new ProxyInvocationHandler();
       pih.setTarget(userService); //设置要代理的对象
       UserService proxy = (UserService)pih.getProxy(); //动态生成代理类！
       proxy.delete();
  }
}
```
测试，增删改查，查看结果！

**动态代理的好处：**  
静态代理有的它都有，静态代理没有的，它也有！
* 可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
* 公共业务就交给代理角色！实现了业务的分工！
* 公共业务发生扩展的时候，方便集中管理！
* 一个动态代理类代理的是一个接口，一般对应的就是一类业务
* 一个动态代理类可以代理多个类，只要是实现了同一个接口即可


# 11、AOP

## 11.1、什么是AOP
AOP（Aspect Oriented Programming）意味：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。AOP是OOP（面向对象）的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。  
![](img/AOP.png)


## 11.2、AOP在Spring中的作用
**提供声明式事务；允许用户自定义切面**  
一下名词需要了解下：
* 横切关注点：跨越应用程序多个模块的方法或功能。就是，与我们业务逻辑无关的，但是我们需要关注的部分，就是横切关注点。例如日志、安全、缓存、事务等等...
* 切面（Aspect）：横切关注点被模块化的特殊对象。即，它是一个类。
* 通知（Adivice）：切面必须要完成的工作。即，它是类中的一个方法。
* 目标（Target）：被通知对象。
* 代理（Proxy）：向目标对象应用通知之后创建的对象。
* 切入点（PointCut）：切面通知执行的“地点”的定义。
* 连接点（JointPoint）：与切入点匹配的执行点。

![](img/AOP各个名词.png)


SpringAOP中，通过Advice定义横切逻辑，Spring中支持5中类型的Advice：  
![](img/Spring中支持的5种类型Advice.png)

即AOP在不改变原有代码的情况下，去增加新的功能。

## 11.3、使用Spring实现AOP
【重点】使用AOP织入，需要导入一个依赖包！
```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```

方式一：使用Spring的Api接口 【主要是SpringAPI接口实现】

方式二：自定义来实现AOP 【主要是切面定义】

方式三：使用注解实现