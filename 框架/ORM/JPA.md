# ORM

ORM是Object Relational Mapping 对象关系映射。

## ORM有什么用？

在操作数据库之前，先把数据表与实体类关联起来。然后通过实体类的对象操作（增删改查）数据库表，这个就是ORM的行为！ 

所以：ORM是一个实现使用对象操作数据库的设计思想！！！ 

通过这句话，我们知道JPA的作用就是通过对象操作数据库的，不用编写sql语句。

# 持久层技术解决方案有几种?

- JDBC技术–>Connection、PreparedStatement、ResultSet
- Spring的JdbcTemplate–>Spring中对Jdbc的简单封装
- Apache的DBUtils–>它和Spring的JdbcTemplate很像，也是对Jdbc的简单封装

以上这些都不是框架(JDBC是规范、Spring的JdbcTemplate和Apache的DBUtils都只是工具类)

# JPA

## 参考

[JPA - 简书 (jianshu.com)](https://www.jianshu.com/p/6d38a6c561f8)



# MyBatis

mybatis是一个用Java编写的持久层框架，它使用ORM实现了结果集的封装。

它封装了jdbc操作的很多细节，使开发者只需要关注sql语句本身，而无需关注注册驱动，创建连接等烦杂过程.

## 测试用例

### 导包

### 配置

### 执行SQL



搭建环境流程如下四点：

1. 创建maven工程并导入坐标

   ```xml
   <dependencies>
   	       <dependency>
   	           <groupId>org.mybatis</groupId>
   	           <artifactId>mybatis</artifactId>
   	           <version>3.4.5</version>
   	       </dependency>
   	       <dependency>
   	           <groupId>mysql</groupId>
   	           <artifactId>mysql-connector-java</artifactId>
   	           <version>5.1.43</version>
   	       </dependency>
   	
   	       <dependency>
   	           <groupId>log4j</groupId>
   	           <artifactId>log4j</artifactId>
   	           <version>1.2.12</version>
   	       </dependency>
   	
   	       <dependency>
   	           <groupId>junit</groupId>
   	           <artifactId>junit</artifactId>
   	           <version>4.10</version>
   	       </dependency>
   	
   </dependencies>
   ```

2. 创建实体类和Mapper的接口

   ```java
   public class User implements Serializable {
   		
   	private int id ;
   	private String username;
   	......
   }
   ```

   ```java
   public interface IUserMapper {
   	/**
   	* 查询所有操作
   	* @return
   	*/
   	List<User> findAll();
   }
   ```

3. 创建mybatis的主配置文件

   ```xml
   <configuration>
       <!--配置环境-->
       <environments default="mysql">
           <!--配置Mysql的环境-->
           <environment id="mysql">
               <!--配置事务的类型-->
               <transactionManager type="JDBC"></transactionManager>
               <!--配置数据源(连接池)-->
               <dataSource type="POOLED">
                   <!--配置连接数据库的四个基本信息-->
                   <property name="driver" value="com.mysql.jdbc.Driver" />
                   <property name="url" value="jdbc:mysql://localhost:3306/db1" />
                   <property name="username" value="root" />
                   <property name="password" value="root" />
               </dataSource>
           </environment>
       </environments>
   
       <mappers>
           <mapper resource="Mybatis/IuserMapper.xml" />
       </mappers>
   
   </configuration>
   ```

4. 创建映射配置文件

   ```xml
   <mapper namespace="com.Mapper.IUserMapper" >
       <select id="findAll" resultType="com.Pojo.User" >
           select * from usr
       </select>
   </mapper>
   ```

   测试方法

   ```java
   ......
   
   InputStream in = Resources.getResourceAsStream("mybatis/MapperConfig.xml");
   //创建SqlSessionFactory工厂
   SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
   SqlSessionFactory factory = builder.build(in);
   //使用工厂生产SqlSession对象
   SqlSession session = factory.openSession();
   //使用SqlSession创建Mapper接口的代理对象
   UserMapper userMapper = session.getMapper(UserMapper.class);
   //使用代理对象执行方法
   List<mybatis_user> users = userMapper.findAll();
   for (mybatis_user muser : users){
       System.out.println(muser);
   }
   session.close();
   in.close();
   
   ......
   ```

## mybatis主配置文件

mybatis的配置文件推荐为命名mybatis-config.xml，其内容包含了会深深影响mybatis行为的设置和属性信息。以下是全配置文件列表：
使用者掌握方面有properties、settings、typeAliases、enveronments、mappers

![image-20220430210157602](../../../../../../../../Program/Projects/ByteMall/doc/微服务/img/image-20220430210157602.png)

## Mapper

使用Mybatis的开发者，大多数都会遇到一个问题，就是要写大量的SQL在xml文件中，除了特殊的业务逻辑SQL之外，还有大量结构类似的增删改查SQL。而且，当数据库表结构改动时，对应的所有SQL以及实体类都需要更改。这工作量和效率的影响或许就是区别增删改查程序员和真正程序员的屏障。这时，通用Mapper便应运而生……

通用Mapper就是为了解决单表增删改查，基于Mybatis的插件。开发人员不需要编写SQL，不需要在DAO中增加方法，只要写好实体类，就能支持相应的增删改查方法。

通用Mapper的原理是通过反射获取实体类的信息，构造出相应的SQL，因此我们只需要维护好实体类即可，对于应付复杂多变的需求提供了很大的便利。上文叙述的只是通用Mapper的简单用法，在实际项目中，还是要根据业务，在通用Mapper的基础上封装出粒度更大、更通用、更好用的方法。

### Maven依赖

```xml
<!-- 通用Mapper --> 
<dependency>    
    <groupId>tk.mybatis</groupId>    
    <artifactId>mapper</artifactId>    
    <version>3.3.9</version> 
</dependency>
```

Spring Boot

Maven:

```xml
<!--mybatis-->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.1</version>
</dependency>
<!--mapper-->
<dependency>
    <groupId>tk.mybatis</groupId>
    <artifactId>mapper-spring-boot-starter</artifactId>
    <version>1.1.4</version>
</dependency>
```



### 实体类

### `DAO`的写法

在传统的Mybatis写法中，`DAO`接口需要与`Mapper`文件关联，即需要编写`SQL`来实现`DAO`接口中的方法。而在通用Mapper中，`DAO`只需要继承一个通用接口，即可拥有丰富的方法：

继承通用的Mapper，必须指定泛型：

```java
public interface TestTableDao extends Mapper<TestTableVO> {
}
```

一旦继承了Mapper，继承的Mapper就拥有了Mapper所有的通用方法：

- **Select**

  - `List<T> select(T record);`

    根据实体中的属性值进行查询，查询条件使用等号

  - `T selectByPrimaryKey(Object key);`

    根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号

  - `List<T> selectAll();`

    查询全部结果，select(null)方法能达到同样的效果

  - `T selectOne(T record);`

    根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号

  - `int selectCount(T record);`

    根据实体中的属性查询总数，查询条件使用等号

- **Insert**

  - `int insert(T record);`

    保存一个实体，null的属性也会保存，不会使用数据库默认值

  - `int insertSelective(T record);`

    保存一个实体，null的属性不会保存，会使用数据库默认值

- **Update**

  - `int updateByPrimaryKey(T record);`

    根据主键更新实体全部字段，null值会被更新

  - `int updateByPrimaryKeySelective(T record);`

    根据主键更新属性不为null的值

- **Delete**

  - `int delete(T record);`

    根据实体属性作为条件进行删除，查询条件使用等号

  - `int deleteByPrimaryKey(Object key);`

    根据主键字段进行删除，方法参数必须包含完整的主键属性

- **Example方法**

  - `List<T> selectByExample(Object example);`

    根据Example条件进行查询

    这个查询支持通过`Example`类指定查询列，通过`selectProperties`方法指定查询列

  - `int selectCountByExample(Object example);`

    根据Example条件进行查询总数

  - `int updateByExample(@Param("record") T record, @Param("example") Object example);`

    根据Example条件更新实体`record`包含的全部属性，null值会被更新

  - `int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);`

    根据Example条件更新实体`record`包含的不是null的属性值

  - `int deleteByExample(Object example);`

    根据Example条件删除数据

### 注解

#### `@Mapper`

在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类
添加位置：接口类上面

```java
@Mapper
public interface UserDAO {
  //代码
}
```

如果想要每个接口都要变成实现类，那么需要在每个接口类上加上@Mapper注解，比较麻烦，解决这个问题用@MapperScan

#### `@MapperScan`

指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
添加位置：是在对应module包下的Springboot启动类上面添加：

```java
@SpringBootApplication
@MapperScan("com.winter.dao")
public class SpringbootMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
    }
}
```

添加@MapperScan(“com.winter.dao”)注解以后，com.winter.dao包下面的接口类，在编译之后都会生成相应的实现类：

```java
@SpringBootApplication  
@MapperScan({"com.kfit.demo","com.kfit.user"})  
public class App {  
    public static void main(String[] args) {  
       SpringApplication.run(App.class, args);  
    }  
} 
```



### 接口方法

`Mapper<T>`接口方法：

```dart
int countByExample(UserExample example) thorws SQLException    按条件计数
int deleteByPrimaryKey(Integer id) thorws SQLException    按主键删除
int deleteByExample(UserExample example) thorws SQLException    按条件查询
String/Integer insert(User record) thorws SQLException    插入数据（返回值为ID）
User selectByPrimaryKey(Integer id) thorws SQLException    按主键查询
ListselectByExample(UserExample example) thorws SQLException    按条件查询
ListselectByExampleWithBLOGs(UserExample example) thorws SQLException    按条件查询（包括BLOB字段）。只有当数据表中的字段类型有为二进制的才会产生。
int updateByPrimaryKey(User record) thorws SQLException    按主键更新
int updateByPrimaryKeySelective(User record) thorws SQLException    按主键更新值不为null的字段
int updateByExample(User record, UserExample example) thorws SQLException    按条件更新
int updateByExampleSelective(User record, UserExample example) thorws SQLException    按条件更新值不为null的字段
```





## 数据过滤

### `Example`

mybatis的逆向工程中会生成实例及实例对应的example，example用于添加条件，相当where后面的部分；

Example类可以构建一个动态的where子句. 表中的每个non-BLOB列可以被包括在where子句中.

```java
xxxExample example = new xxxExample();
Criteria criteria = new Example().createCriteria();
```



#### 方法

```csharp
example.setOrderByClause(“字段名 ASC”);    添加升序排列条件，DESC为降序
example.setDistinct(false)    去除重复，boolean型，true为选择不重复的记录。
criteria.andXxxIsNull    添加字段xxx为null的条件
criteria.andXxxIsNotNull    添加字段xxx不为null的条件
criteria.andXxxEqualTo(value)    添加xxx字段等于value条件
criteria.andXxxNotEqualTo(value)    添加xxx字段不等于value条件
criteria.andXxxGreaterThan(value)    添加xxx字段大于value条件
criteria.andXxxGreaterThanOrEqualTo(value)    添加xxx字段大于等于value条件
criteria.andXxxLessThan(value)    添加xxx字段小于value条件
criteria.andXxxLessThanOrEqualTo(value)    添加xxx字段小于等于value条件
criteria.andXxxIn(List<？>)    添加xxx字段值在List<？>条件
criteria.andXxxNotIn(List<？>)    添加xxx字段值不在List<？>条件
criteria.andXxxLike(“%”+value+”%”)    添加xxx字段值为value的模糊查询条件
criteria.andXxxNotLike(“%”+value+”%”)    添加xxx字段值不为value的模糊查询条件
criteria.andXxxBetween(value1,value2)    添加xxx字段值在value1和value2之间条件
criteria.andXxxNotBetween(value1,value2)    添加xxx字段值不在value1和value2之间条件
```

#### `Criteria`

Example类包含一个内部静态类 Criteria 包含一个用 anded 组合在where子句中的条件列表

创建 Criteria 对象 可以使用Example类中的 createCriteria() 或者 or()

- 如果 Criteria 对象是用 createCriteria() 创建的，它会自动为 List 属性添加一个 Criteria 对象 - 这使得它更容易写一个简单的where子句
- 如果您不需要 or 或者其他几个子句组合的话. 用 or(Criteria criteria) 方法创建 Criteria 对象, 方法里的 criteria 对象会被添加进 Criteria 对象的列表中.

推荐您只使用 or() 方法创建 Criteria 对象. 我们相信这种方法使代码更有可读性.

### 简单查询



## 参考

https://blog.csdn.net/qq_21561501/article/details/123649171

https://blog.csdn.net/qq_43496435/article/details/119214957

[Mapper](https://blog.csdn.net/dwf_android/article/details/79359360)

[Example](https://zhuanlan.zhihu.com/p/42411540)

[mybatis Example 使用方法 ](https://www.jianshu.com/p/d022fbbc3f8c)

[MyBatis中通用Mapper接口以及Example的方法解析](https://www.cnblogs.com/tian-ci/p/10543089.html)

[@MapperScan注解使用](https://blog.csdn.net/manchengpiaoxue/article/details/84937257)

# MyBatis-Plus

[MyBatis-Plus](https://github.com/baomidou/mybatis-plus)（简称 MP）是一个 [MyBatis](http://www.mybatis.org/mybatis-3/) 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

## 参考

https://blog.csdn.net/zdsg45/article/details/105138493/

