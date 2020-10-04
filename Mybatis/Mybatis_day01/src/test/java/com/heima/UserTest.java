package com.heima;

import com.heima.dao.UserMapper;
import com.heima.domain.QueryVo;
import com.heima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class UserTest {
    private  InputStream inputStream;
    private  SqlSessionFactory factory;
    private  SqlSession session;
    private  UserMapper userMapper;
//    初始化方法
    @Before
    public void init()throws IOException{
        //        1.读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建sqlsessionfactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(inputStream);
//        3.使用工厂创建sqlsession对象
        session = factory.openSession();//可以在这开启自动提交true，默认关闭：false
//        4.使用sqlsession对象创建dao接口代理对象
        userMapper = session.getMapper(UserMapper.class);
    }

//  释放资源
    @After
    public void destoryed()throws IOException{
//        提交事务,增删改都要提交事务，否则无法完成
        session.commit();
        session.close();
        inputStream.close();
    }

//    查询用户列表
    @Test
    public void shouldAnswerWithTrue()  {

//        5.使用代理对象执行查询sql语句
        List<User> users = userMapper.findAll();
//        将结果进行遍历
        for(User user:users){
            System.out.println(user);
        }
    }

//    添加用户
    @Test
    public void add(){
        User user=new User();
        user.setUsername("妹爷");
        user.setBirthday(new Date());
        user.setSex('男');
        user.setAddress("广东包子林");
        System.out.println("保存前："+user);
        userMapper.AddUser(user);
        System.out.println("保存后："+user);
    }

    //    更新用户
    @Test
    public void update(){
        User user=new User();
        user.setId(51);
        user.setUsername("加多宝");
        user.setAddress("广东一品");
        userMapper.updateUser(user);
    }

    //    删除用户
    @Test
    public void delete(){
        userMapper.deleteUser(43);
    }

    //    根据ID查询用户
    @Test
    public void selectById(){
        User user = userMapper.selectUserById(49);
        System.out.println(user);
    }

    //    根据姓名模糊查询用户
    @Test
    public void selectUserName(){
        List<User> users = userMapper.selectUserByName("%王%");
//        List<User> users = userMapper.selectUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }

    }

    //    获取所有的用户数量
    @Test
    public void findTotalUser(){
        Integer userAll = userMapper.findUserAll();
        System.out.println(userAll);
    }

    //    模糊查询用户
    @Test
    public void selectAllUserByName(){
        QueryVo vo =new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> allUerByName = userMapper.findAllUerByName(vo);
        for (User u : allUerByName) {
            System.out.println(u);
        }
    }

    //    根据条件查询用户名
    @Test
    public void selectUserNameByCondition(){
        User user=new User();
        user.setId(42);
        user.setUsername("小二王");
        List<User> userNameByCondition = userMapper.findUserNameByCondition(user);
        for (User user1 : userNameByCondition) {
            System.out.println(user1);
        }
    }

    //    根据id集合查询用户
    @Test
    public void selectUserByIds(){
        QueryVo vo =new QueryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(42);
        list.add(43);
        list.add(45);
        vo.setIds(list);
        List<User> userByIds = userMapper.findAllUserByIds(vo);
        for (User userById : userByIds) {
            System.out.println(userById);
        }
    }

//    查询所有用户的所有账户
    @Test
    public void selectAllUserAccountd(){
        List<User> allUserAccount = userMapper.findAllUserAccount();
        for (User user : allUserAccount) {
            System.out.println("每个用户为：");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
