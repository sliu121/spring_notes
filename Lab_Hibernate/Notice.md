# Hibernate 从入门到放弃

---

## hibernate 核心类和接口

![hibernate核心类和接口.img](img\hibernate核心类和接口.PNG)

### **第一层 配置文件**

hibernate.cfg.xml 是配置文件，\*.hbm.xml 是 mapping 文件，hibernate.properties 是以前用于配置的文件

- hibernate.cfg.xml 配置详解：

  - `<property name="hibernate.connection.driver_class">` >> 用于配置数据库读取模块
  - `<property name="hibernate.connection.url">` >> 用于连接数据库
  - `<property name="hibernate.connection.username">` >> 数据库用户名
  - `<property name="hibernate.connection.password">` >> 数据库密码
  - `<property name="dialect">` >> 配置 dialect, 告诉 hibernate 连接的数据库类型
  - `<mapping resource="*.hbm.xml" />` >> 指定管理的对象映射文件

- \*.hbm.xml:
  - 该文件主要作用时间里表和类的映射关系，是不可或缺的重要文件
  - 一般放在其映射的类的同一个目录下(非必要)
  - 命名方式一般是*类名.hmb.xml*(非必要)

### **第二层 Configuration**

Configuration is a Class, it has a function _configure()_, which use the mappings and properties specified in an application resource named _hibernate.cfg.xml_.
If you have a different file name rather than _hibernate.cfg.xml_， you can add res file name as _configure(*res_path*)_.

1. 负责管理 hibernate 的配置信息
2. 读取 _hibernate.cfg.xml_
3. 加载 _hibernate.cfg.xml_ 配置文件中的驱动, url, 用户名, 密码, 连接池
4. 管理 _\*.hbm.xml_ 对象关系文件

### **第三层 SessionFactory**

SessionFactory is an Interface.

![会话工厂.PNG](img\会话工厂.PNG)

1. 缓存 sql 语句和某些数据 (Session 级缓存)
2. 是一个重量级的类(吃内存严重), 因此我们们需要保证一个数据库只有一个 SessionFactory 实例
3. 通过 SessionFactory 接口可以获取 Session 实例
4. 两个获取 session 的方法：_openSession()_ and _getCurrentSession()_
5. 在 SessionFactory 启动的时候，Hibernate 会根据配置创建相应的 CurrentSessionContext，在 getCurrentSession()被调用的时候，实际执行的方法是 CurrentSessionContext.currentSession(). <br>在 currentSession()执行时，如果当前 Session 为空，currentSession 会调用 SessionFactory 的 openSession

   **_openSession()_ and _getCurrentSession()_ 的区别：**

   | 区别           |               openSession()               |                                                                                                                                  getCurrentSession()                                                                                                                                   |
   | -------------- | :---------------------------------------: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
   | **属性**       |          是获取一个新的 session           | 是获取和当前线程绑定的 session, 换言之，在同一线程中，我们获取的 session 是同一个 session, 这样有利于事务控制<br>(_如果想使用 getCurrentSession(),我们需要在 hibernate.cfg.xml 文件中进行配置调整，\*`<property name = "current_session_context_class">'thread' or 'jta'</property>`_) |
   | **关闭**       |               必须手动关闭                |                                                                                                                    事务提交以后 (_commit()_, _rollback()_) 自动关闭                                                                                                                    |
   | **数据库查询** | 直接使用 session.load()就可以直接读取内容 |                                                                                                          必须新建一个 Transaction 才能读取，然后 session.load() 就可以使用了                                                                                                           |
   | **使用原则**   |      一个线程需要使用不同的 Session       |                                                                                                                             同一线程需要使用同一个 Session                                                                                                                             |

   \* **_Jta vs Thread(JDBC):_**

   - _Thread(JDBC) 是本地事务，Jta 是全局事务(跨数据库事务)_

### **第四层 Session**

1. 一个实例代表与数据库的一次操作
2. 通过 SessionFactory 获取，用完关闭
3. Session 是线程不同步的(不安全), 因此在同一线程中使用，可以使用*getCurrentSession()*
4. Session 可以看作是持久化管理器，与持久化操作相关的接口
5. 常用方法：
   - SELECT: get(), load()
   - INSERT：save(), persist()
   - UPDATE: update(), merge()
   - DELETE: delete()

区别大军来额：

- get() vs load():
  | 区别         |                            get()                            |                                                    load()                                                    |
  | ------------ | :---------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------: |
  | **返回值**   |              直接返回实体类，查不到则返回 null              | 返回一个实体代理对象，如果这个代理对象的数据不存在，调用时会抛出一个 _org.hibernate.ObjectNotFoundException_ |
  | **数据查询** |                  立即向数据库发送 sql 语句                  |                          只有在调用代理对象时，才会向数据库发送 sql 语句 \*(懒加载)                          |
  | **数据读取** | 先到缓存(session 缓存/二级缓存)查找，如果没有立即到 DB 查询 |  先到缓存(session 缓存/二级缓存)如果没有则返回一个代理对象，等到用户使用该对象时，再到 DB 中查询\*(懒加载)   |
  | **使用原则** |                  查询数据存在不确定时使用                   |                                            查询数据确定存在时使用                                            |

\*[懒加载](#懒加载)：通过修改配置文件，我们可以取消懒加载.



- save() vs persist()

  | 区别         |                            Save()                            |                          Persist()                           |
  | ------------ | :----------------------------------------------------------: | :----------------------------------------------------------: |
  | **返回值**   | Returns generated Id after saving. Its return type is `Serializable` | Does not return generated Id after saving. Its return type is `void` |
  | **数据存储** | Saves changes to db even its outside of the transaction;<br /><br/> Executed immediately, irrespective of the state of the transaction and the identifier is returned thereafter | Only saves changes to db when its inside transaction boundaries<br /><br />Does not necessarily ensure or guarantee that the identifier is assigned to the persistent object immediately |
  | **数据状态** | Invoke save API on detached instances will create a new row in the table | Invoke persist() on detached instances will throw an exception, as it is not allowed |

  

- update() vs merge():

  for a object has a primary key, we can only have one in persistence status.

  update() -> convert detached instance to persistence status, if there already exist one, it will throw an exception

  merge() -> if there exists an same object in persistence lay, we'll copy the info from the detached instant to the persistent one.

### **第五层-1 Query (hql 语句)**

1. get 和 load 是 id 查询使用的，如果需要高级的查询，我们就需要用 query 查询语句
2. 通过 Query 接口我们可以完成更加复杂的查询任务

   > **// 获取 query 引用 [这里的是类名，不是数据库中的 table_name]**
   > Query query1 = session.createQuery("select myrecord from com.eca.hibernate.Account as myrecord");
   > **// where 跟随的条件可以是映射对象的属性名称，也可以是对应的表的字段名称**
   > Query query2 = session.createQuery("from Account where id = 1");
   > // 获取结果
   > List list = query.list();
   > **// 通过 list 方法获取结果，这个 list 会自动地将结果封装成对应的 domain 对象** > **// jdbc 进行二次封装的工作没有**

**第五层-2 Criteria**
Criteria 接口也可以用于面向对象方式的查询：
基本用法：

> Criteria cri = session.createCriteria(Account.class)._following methods(条件语句)_

---

## eclipse 进行 hibernate 快速开发

1. db(table) >> 手写 domain 对象 >> 对象关系映射文件
2. 用工具完成 domain 对象和关系映射文件
   1. 新建一个 web 项目
   2. 通过 eclipse 提供的数据库浏览器连接到我们的数据库(Window -> Perspective -> Open Perspective -> DataBase Development)
   3. 配置 DataBase Connections, 引入 JDBC driver
   4. 引入 hibernate
   5. 使用 myeclipse 提供的逆向工程，生成一个映射文件

。。。具体操作过程在 Lab-HibernateReverseEngineering 中可以见到

---

## HQL 详解

删除：session.delete()
查询：session.load(), session.get() [这两个只能用于主键查询]), hql
修改：session.update(), session.merge()
添加：session.save(), session.persist();

### **HQL 简介**

面对对象的查询语句，与 SQL 不同，HQL 中的对象名是区分大小写的(除了 JAVA 类和属性其他部分不区分大小写)；
HQL 中查的是对象而不是表，并且支持多态；
HQL 主要通过 Query 来操作；
Query 的创建方式：
Query query = session.ceateQuery(hql);

   - from Person
   - from User user where user.name = : name
   - from User user where user,.name = name nad and user.birthday <: bday

### **HQL查询**

推荐使用全属性查询，即：*select * from table_name where ...* 这样我们得到的是一个类集合。如果用部分属性查询，我们得到的是Object集合
当你确认查询数据在数据库中只有一条，或者查询条件是唯一的，那么我们应该使用：*uniqueResult(): Convenience method to return a single instance that matches the query, or null if the query returns no results*

---

## **懒加载**

#### 什么是懒加载：

​	当我们查询一个对象时，在默认情况下方法返回的是该对象的普通属性，当用户去使用对象的关联属性时，才会向数据库再次发出查询请求。

#### 示例：

```java
class Student{
    private Integer id;
    private String name;
    private Department dept;
    // getter() & setter()
}

class Department{
    private Integer id;
    private String name;
    //getter() & setter()
}

class Test{
    public static void main(String[] args){
        Student stu = getStudent(1);
        System.out.println(stu.getdept().getname()); // --> 直接报错，因为Hibernate此时不会再去db里找相关内容了
    }
    
    public static Student getStudent(Integer id){
        Session s = null;
        Transaction ts = null;
        Student stu = null;
        try{
            s = HibernateUtil.getCurrentSession();
            ts = s.beginTransaction();
            
            stu = (student) s.get(Student.class, id);
            System.out.println(s.getdept().getname()); //--> 此时会有输出值，因为Hibernate会自己再去数据库里找对应的department。
            tx.commit();
            
        }catch(Exception e){
            if(ts!= null){
                ts.rollback();
            }
        }finally{
            if(s!=null && s.isOpen()){
                s.close();
            }
        }
        
        return stu;
    }
}

```

